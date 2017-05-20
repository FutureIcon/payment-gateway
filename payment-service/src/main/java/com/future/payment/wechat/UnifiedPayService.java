package com.future.payment.wechat;

import com.tencent.service.BaseService;

public class UnifiedPayService extends BaseService {

	private static String UNIFIED_PAY_API = "https://api.mch.weixin.qq.com/pay/unifiedorder";

	public UnifiedPayService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
		super(UNIFIED_PAY_API);
	}

	/**
	 * 请求支付服务
	 * 
	 * @param scanPayReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的数据
	 * @throws Exception
	 */
	public String request(UnifiedPayReqData scanPayReqData) throws Exception {

		// --------------------------------------------------------------------
		// 发送HTTPS的Post请求到API地址
		// --------------------------------------------------------------------
		return sendPost(scanPayReqData);

	}
}
