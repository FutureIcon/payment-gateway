package com.future.payment.wechat;

import com.tencent.common.Configure;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.service.ScanPayQueryService;

/**
 * SDK总入口
 */
public class ScanQrCodePay {

    /**
     * 初始化SDK依赖的几个关键配置
     * @param key 签名算法需要用到的秘钥
     * @param appID 公众账号ID
     * @param mchID 商户ID
     * @param sdbMchID 子商户ID，受理模式必填
     * @param certLocalPath HTTP证书在服务器中的路径，用来加载证书用
     * @param certPassword HTTP证书的密码，默认等于MCHID
     */
    public static void initSDKConfiguration(String key,String appID,String mchID,String sdbMchID,String certLocalPath,String certPassword){
        Configure.setKey(key);
        Configure.setAppID(appID);
        Configure.setMchID(mchID);
        Configure.setSubMchID(sdbMchID);
        Configure.setCertLocalPath(certLocalPath);
        Configure.setCertPassword(certPassword);
    }
    
    public static UnifiedPayResData getCodeUrl(UnifiedPayReqData unifiedPayReqData, ScanQrCodePayBusiness.ResultListener resultListener) throws Exception{
		return new ScanQrCodePayBusiness().getCodeUrl(unifiedPayReqData, resultListener);
	}
    
    public static String processNotify() throws Exception {
    	return new ScanQrCodePayBusiness().processNotify();
    }
    
    public static ScanPayQueryResData orderQuery(String outTradeNo) throws Exception{
		return new ScanQrCodePayBusiness().orderQuery(outTradeNo);
	}

	public static String requestScanPayQueryService(ScanPayQueryReqData scanPayQueryReqData) throws Exception{
		return new ScanPayQueryService().request(scanPayQueryReqData);
	}
	
	public static String requestUnifiedPayService(UnifiedPayReqData unifiedPayReqData) throws Exception{
		return new UnifiedPayService().request(unifiedPayReqData);
	}
	
    
}
