package com.future.payment.plugin.wechat;

import org.springframework.stereotype.Component;

import com.future.payment.dto.PayTransactionDTO;
import com.tencent.WXPay;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_protocol.ScanPayResData;

//@Component
public class WechatPay extends AbstractWechatPaymentOperation {
	
	
    /**
     * Override method to execute payment operations.
     * @throws Exception 
     */
	@Override
	public void executeWechatTransaction(PayTransactionDTO dto) throws Exception  {
		
		//1）创建一个可以用来生成数据的bridge，这里用的是一个专门用来测试用的Bridge，商户需要自己实现
		ScanPayBusinessBridge bridge  = new ScanPayBusinessBridge();
        //2）从bridge里面拿到数据，构建提交被扫支付API需要的数据对象
        ScanPayReqData scanPayReqData = new ScanPayReqData(
                //这个是扫码终端设备从用户手机上扫取到的支付授权号，有效期是1分钟
                bridge.getAuthCode(),
                //要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
                bridge.getBody(),
                //支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
                bridge.getAttach(),
                //商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
                bridge.getOutTradeNo(),
                //订单总金额，单位为“分”，只能整数
                bridge.getTotalFee(),
                //商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
                bridge.getDeviceInfo(),
                //订单生成的机器IP
                bridge.getSpBillCreateIP(),
                //订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010
                bridge.getTimeStart(),
                //订单失效时间，格式同上
                bridge.getTimeExpire(),
                //商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
                bridge.getGoodsTag()
        );

        DefaultScanPayBusinessResultListener resultListener = new DefaultScanPayBusinessResultListener();

        WXPay.doScanPayBusiness(scanPayReqData,resultListener);
        
        //TO-DO
        ScanPayResData scanPayResData = null;
        updateDtoByScanPayResponse(dto, scanPayResData);
		
	}

	protected void updateDtoByScanPayResponse(PayTransactionDTO dto, ScanPayResData scanPayResData) {
	}
	
}
