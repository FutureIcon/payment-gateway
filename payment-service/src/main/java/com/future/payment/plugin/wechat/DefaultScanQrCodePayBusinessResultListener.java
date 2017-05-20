package com.future.payment.plugin.wechat;

import com.future.payment.wechat.ScanQrCodePayBusiness;
import com.future.payment.wechat.UnifiedPayResData;


public class DefaultScanQrCodePayBusinessResultListener implements ScanQrCodePayBusiness.ResultListener {

    public static final String ON_FAIL_BY_RETURN_CODE_ERROR = "on_fail_by_return_code_error";
    public static final String ON_FAIL_BY_RETURN_CODE_FAIL = "on_fail_by_return_code_fail";
    public static final String ON_FAIL_BY_SIGN_INVALID = "on_fail_by_sign_invalid";

    public static final String ON_SUCCESS = "on_success";

    private String result = "";
    private String transcationID = "";

    /**
     * 遇到这个问题一般是程序没按照API规范去正确地传递参数导致，请仔细阅读API文档里面的字段说明
     */
    public void onFailByReturnCodeError(UnifiedPayResData unifiedPayResData) {
        result = ON_FAIL_BY_RETURN_CODE_ERROR;
    }

    /**
     * 同上，遇到这个问题一般是程序没按照API规范去正确地传递参数导致，请仔细阅读API文档里面的字段说明
     */
    public void onFailByReturnCodeFail(UnifiedPayResData unifiedPayResData) {
        result = ON_FAIL_BY_RETURN_CODE_FAIL;
    }

    /**
     * 支付请求API返回的数据签名验证失败，有可能数据被篡改了。遇到这种错误建议商户直接告警，做好安全措施
     */
    public void onFailBySignInvalid(UnifiedPayResData unifiedPayResData) {
        result = ON_FAIL_BY_SIGN_INVALID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTranscationID() {
        return transcationID;
    }

    public void setTranscationID(String transcationID) {
        this.transcationID = transcationID;
    }

	@Override
	public void onSuccess(UnifiedPayResData unifiedPayResqData, String transactionID) {
		// TODO Auto-generated method stub
		result = ON_SUCCESS;
	}
}
