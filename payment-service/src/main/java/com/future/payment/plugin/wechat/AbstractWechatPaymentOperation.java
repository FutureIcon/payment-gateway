package com.future.payment.plugin.wechat;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.plugin.PaymentOperation;
import com.tencent.WXPay;

public abstract class AbstractWechatPaymentOperation implements PaymentOperation {
	
	
	protected static void init(){
		WXPay.initSDKConfiguration(
                //签名算法需要用到的秘钥
                "d39fd2808ee332cfc8ba9c5future2017",
                //公众账号ID，成功申请公众账号后获得
                "wx521ac2e00438eb39",
                //商户ID，成功申请微信支付功能之后通过官方发出的邮件获得
                "1441583502",
                //子商户ID，受理模式下必填；
                "",
                //HTTP证书在服务器中的路径，用来加载证书用
                "D:\\apiclient_cert.p12",
                //HTTP证书的密码，默认等于MCHID
                "1441583502"
        );
	}
    
    /**
     * Override method to execute payment operations.
     */
	@Override
	public void execute(PayTransactionDTO dto)  {
		
		//Validate plugin request
		//getValidator().validateRequest(dto);
		
		try {
			executeWechatTransaction(dto);
        } catch (Exception e) {
            handleException(dto, e);
        }		

	}

	protected void handleException(PayTransactionDTO dto, Exception e) {
	    
    }

    protected abstract void executeWechatTransaction(PayTransactionDTO dto) throws Exception;
	
	//protected abstract BaseValidator getValidator();
	
}
