package com.future.payment.wechat;

import static java.lang.Thread.sleep;

import org.slf4j.LoggerFactory;

import com.tencent.common.Log;
import com.tencent.common.Signature;
import com.tencent.common.Util;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.service.ScanPayQueryService;
import com.thoughtworks.xstream.XStream;

public class ScanQrCodePayBusiness {

	// 打log用
	private static Log log = new Log(LoggerFactory.getLogger(ScanQrCodePayBusiness.class));

	// 每次调用订单查询API时的等待时间，因为当出现支付失败的时候，如果马上发起查询不一定就能查到结果，所以这里建议先等待一定时间再发起查询

	private int waitingTimeBeforePayQueryServiceInvoked = 5000;

	private UnifiedPayService unifiedPayService;

	private ScanPayQueryService scanPayQueryService;

	public ScanQrCodePayBusiness() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
		unifiedPayService = new UnifiedPayService();
		scanPayQueryService = new ScanPayQueryService();
	}

	public interface ResultListener {

		// API返回ReturnCode不合法，支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问
		void onFailByReturnCodeError(UnifiedPayResData unifiedPayResData);

		// API返回ReturnCode为FAIL，支付API系统返回失败，请检测Post给API的数据是否规范合法
		void onFailByReturnCodeFail(UnifiedPayResData unifiedPayResData);

		// 支付请求API返回的数据签名验证失败，有可能数据被篡改了
		void onFailBySignInvalid(UnifiedPayResData unifiedPayResData);

		// 支付成功
		void onSuccess(UnifiedPayResData unifiedPayResqData, String transactionID);

	}

	public String processNotify() throws Exception {
		String notifyData = getNotifyData();
		NotifyResData notifyReqData = null;
		NotifyReqData notify = (NotifyReqData) Util.getObjectFromXML(notifyData, NotifyReqData.class);
		String outTradeNo = notify.getOut_trade_no();
		String transactionId = notify.getTransaction_id();
		if (outTradeNo != null && transactionId != null) {
			if (orderQuery(transactionId, outTradeNo)) {
				notifyReqData = new NotifyResData("SUCCESS", "OK");
				
			} else {
				notifyReqData = new NotifyResData("FAIL", "订单查询失败");
			}
			
		} else {
			notifyReqData = new NotifyResData("FAIL", "支付结果中微信订单号不存在");
		}
		XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.toXML(notifyReqData);

	}
	
	public String getNotifyData() {
		return null;
	}

	public UnifiedPayResData getCodeUrl(UnifiedPayReqData unifiedPayReqData, ResultListener resultListener) throws Exception {

		// 接受API返回
		String responseString;

		long costTimeStart = System.currentTimeMillis();

		log.i("支付API返回的数据如下：");
		responseString = unifiedPayService.request(unifiedPayReqData);

		long costTimeEnd = System.currentTimeMillis();
		long totalTimeCost = costTimeEnd - costTimeStart;
		log.i("api请求总耗时：" + totalTimeCost + "ms");
		log.i("支付API返回的数据如下：");

		UnifiedPayResData response = (UnifiedPayResData) Util.getObjectFromXML(responseString, UnifiedPayResData.class);

		if (response == null || response.getReturn_code() == null) {
			log.e("【支付失败】支付请求逻辑错误，请仔细检测传过去的每一个参数是否合法，或是看API能否被正常访问");
			resultListener.onFailByReturnCodeError(response);
			return null;
		}

		if (response.getReturn_code().equals("FAIL")) {
			// 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
			log.e("【支付失败】支付API系统返回失败，请检测Post给API的数据是否规范合法");
			resultListener.onFailByReturnCodeFail(response);
			return null;
		} else {
			log.i("支付API系统成功返回数据");
			// --------------------------------------------------------------------
			// 收到API的返回数据的时候得先验证一下数据有没有被第三方篡改，确保安全
			// --------------------------------------------------------------------
			if (!Signature.checkIsSignValidFromResponseString(responseString)) {
				log.e("【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了");
				resultListener.onFailBySignInvalid(response);
				return null;
			}

			if (response.getResult_code().equals("SUCCESS")) {

				// --------------------------------------------------------------------
				// 1)直接扣款成功
				// --------------------------------------------------------------------

				log.i("【一次性支付成功】");

				String codeUrl = response.getCode_url();
				if (codeUrl != null && codeUrl.trim().length() > 0) {
					resultListener.onSuccess(response, codeUrl);
					return response;
				}
			}
		}
		return response;
	}

	public boolean orderQuery(String transactionId, String outTradeNo) throws Exception {

		sleep(waitingTimeBeforePayQueryServiceInvoked);// 等待一定时间再进行查询，避免状态还没来得及被更新

		String payQueryServiceResponseString;

		ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData(transactionId, outTradeNo);
		payQueryServiceResponseString = scanPayQueryService.request(scanPayQueryReqData);

		log.i("支付订单查询API返回的数据如下：");
		log.i(payQueryServiceResponseString);

		// 将从API返回的XML数据映射到Java对象
		ScanPayQueryResData scanPayQueryResData = (ScanPayQueryResData) Util
				.getObjectFromXML(payQueryServiceResponseString, ScanPayQueryResData.class);
		if (scanPayQueryResData == null || scanPayQueryResData.getReturn_code() == null) {
			log.i("支付订单查询请求逻辑错误，请仔细检测传过去的每一个参数是否合法");
			return false;
		}

		if (scanPayQueryResData.getReturn_code().equals("FAIL")) {
			// 注意：一般这里返回FAIL是出现系统级参数错误，请检测Post给API的数据是否规范合法
			log.i("支付订单查询API系统返回失败，失败信息为：" + scanPayQueryResData.getReturn_msg());
			return false;
		} else {

			if (!Signature.checkIsSignValidFromResponseString(payQueryServiceResponseString)) {
				log.e("【支付失败】支付请求API返回的数据签名验证失败，有可能数据被篡改了");
				return false;
			}

			if (scanPayQueryResData.getResult_code().equals("SUCCESS")) {// 业务层成功
				if (scanPayQueryResData.getTrade_state().equals("SUCCESS")) {
					// 表示查单结果为“支付成功”
					log.i("查询到订单支付成功");
					return true;
				} else {
					// 支付不成功
					log.i("查询到订单支付不成功");
					return false;
				}
			} else {
				log.i("查询出错，错误码：" + scanPayQueryResData.getErr_code() + "     错误信息："
						+ scanPayQueryResData.getErr_code_des());
				return false;
			}
		}
	}
	
	public ScanPayQueryResData orderQuery(String outTradeNo) throws Exception {

		sleep(waitingTimeBeforePayQueryServiceInvoked);// 等待一定时间再进行查询，避免状态还没来得及被更新

		String payQueryServiceResponseString;

		ScanPayQueryReqData scanPayQueryReqData = new ScanPayQueryReqData("", outTradeNo);
		payQueryServiceResponseString = scanPayQueryService.request(scanPayQueryReqData);

		log.i("支付订单查询API返回的数据如下：");
		log.i(payQueryServiceResponseString);

		// 将从API返回的XML数据映射到Java对象
		ScanPayQueryResData scanPayQueryResData = (ScanPayQueryResData) Util
				.getObjectFromXML(payQueryServiceResponseString, ScanPayQueryResData.class);
		if (scanPayQueryResData != null || scanPayQueryResData.getReturn_code() != null) {
			return scanPayQueryResData;
		}
		return null;
	}

	/**
	 * 设置循环多次调用订单查询API的时间间隔
	 *
	 * @param duration
	 *            时间间隔，默认为10秒
	 */
	public void setWaitingTimeBeforePayQueryServiceInvoked(int duration) {
		waitingTimeBeforePayQueryServiceInvoked = duration;
	}

	public void setScanPayQueryService(ScanPayQueryService service) {
		scanPayQueryService = service;
	}

	public void setUnifiedPayService(UnifiedPayService unifiedPayService) {
		this.unifiedPayService = unifiedPayService;
	}
	

}
