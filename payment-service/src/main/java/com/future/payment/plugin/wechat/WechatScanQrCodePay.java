package com.future.payment.plugin.wechat;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.enums.PaymentResult;
import com.future.payment.enums.TradeState;
import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;
import com.future.payment.persistence.modeling.PayReqData;
import com.future.payment.persistence.repository.WechatPayReqRepository;
import com.future.payment.wechat.ScanQrCodePay;
import com.future.payment.wechat.UnifiedPayReqData;
import com.future.payment.wechat.UnifiedPayResData;
import com.tencent.WXPay;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;

//@Component
public class WechatScanQrCodePay extends AbstractWechatPaymentOperation {

	@Autowired
	private WechatPayReqRepository wechatPayReqRepository;
	
	public UnifiedPayResData getCodeUrl(String tradeNo) throws Exception {

		WXPay.initSDKConfiguration(
				// 签名算法需要用到的秘钥
				"d39fd2808ee332cfc8ba9c5future2017",
				// 公众账号ID，成功申请公众账号后获得
				"wx521ac2e00438eb39",
				// 商户ID，成功申请微信支付功能之后通过官方发出的邮件获得
				"1441583502",
				// 子商户ID，受理模式下必填；
				"",
				// HTTP证书在服务器中的路径，用来加载证书用
				"D:\\apiclient_cert.p12",
				// HTTP证书的密码，默认等于MCHID
				"1441583502");

		// 1）创建一个可以用来生成数据的bridge，这里用的是一个专门用来测试用的Bridge，商户需要自己实现
		UnifiedPayBusinessBridge bridge = new UnifiedPayBusinessBridge();
		// 2）从bridge里面拿到数据，构建提交被扫支付API需要的数据对象
		UnifiedPayReqData unifiedPayReqData = new UnifiedPayReqData(
				// 这个是扫码终端设备从用户手机上扫取到的支付授权号，有效期是1分钟
				bridge.getAuthCode(),
				// 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
				bridge.getBody(),
				// 支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
				bridge.getAttach(),
				// 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
				// bridge.getOutTradeNo(),
				tradeNo,
				// 订单总金额，单位为“分”，只能整数
				bridge.getTotalFee(),
				// 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
				bridge.getDeviceInfo(),
				// 订单生成的机器IP
				bridge.getSpBillCreateIP(),
				// 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
				bridge.getTimeStart(),
				// 订单失效时间，格式同上
				bridge.getTimeExpire(),
				// 商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
				bridge.getGoodsTag());

		DefaultScanQrCodePayBusinessResultListener resultListener = new DefaultScanQrCodePayBusinessResultListener();

		UnifiedPayResData codeUrl = ScanQrCodePay.getCodeUrl(unifiedPayReqData, resultListener);
		
		PayReqData data = new PayReqData();
		BeanUtils.copyProperties(unifiedPayReqData, data);
		data.setPay_channel("微信支付");
		data.setFee_type("CNY");
		data.setTrade_state(TradeState.NOTPAY.name());
		/*if (data.getRequestId()== null) {
			data.setRequestId(UUIDs.timeBased());
		}*/
		//wechatPayReqRepository.save(data);
		return codeUrl;
	}

	public PaymentResponse orderQuery(PaymentRequest request) throws Exception {
		
		WXPay.initSDKConfiguration(
				// 签名算法需要用到的秘钥
				"d39fd2808ee332cfc8ba9c5future2017",
				// 公众账号ID，成功申请公众账号后获得
				"wx521ac2e00438eb39",
				// 商户ID，成功申请微信支付功能之后通过官方发出的邮件获得
				"1441583502",
				// 子商户ID，受理模式下必填；
				"",
				// HTTP证书在服务器中的路径，用来加载证书用
				"D:\\apiclient_cert.p12",
				// HTTP证书的密码，默认等于MCHID
				"1441583502");
		
		String tradeNo = request.getOrderNumber();

		ScanPayQueryResData data = ScanQrCodePay.orderQuery(tradeNo);
		
		PaymentResponse response = new PaymentResponse(PaymentResult.NORMAL);
		BeanUtils.copyProperties(data, response);
		
		return response;
	}

	protected void updateDtoByUnifiedPayResponse(PayTransactionDTO dto, UnifiedPayResData unifiedPayResData) {
	}

	@Override
	protected void executeWechatTransaction(PayTransactionDTO dto) throws Exception {
		// TODO Auto-generated method stub

	}

}
