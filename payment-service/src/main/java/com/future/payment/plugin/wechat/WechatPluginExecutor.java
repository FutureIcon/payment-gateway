package com.future.payment.plugin.wechat;


import java.util.Map;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.plugin.PaymentOperation;
import com.future.payment.plugin.PluginExecutor;

public class WechatPluginExecutor implements PluginExecutor {
	
	private Map<String, PaymentOperation> paymentOperationMapper; 
	
	/**
	 * Override method, 
	 * a) Find correct operation bean from the operation mapper and
	 * b) Call the execute on that operation object.
	 */
	@Override
	public void execute(final String identifier, PayTransactionDTO dto) {
		getPaymentOperationMapper().get(identifier).execute(dto);
	}
	
	public Map<String, PaymentOperation> getPaymentOperationMapper() {
		return paymentOperationMapper;
	}

	public void setPaymentOperationMapper(
			final Map<String, PaymentOperation> paymentOperationMapper) {
		this.paymentOperationMapper = paymentOperationMapper;
	}

}
