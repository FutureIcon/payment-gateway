package com.future.payment.bo;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.plugin.PaymentPlugin;

public abstract class AbstractBO<DTO extends PayTransactionDTO> implements PaymentBO<DTO> {

	public DTO processRequest(DTO payTransactionDto) {

		//find plugin: wechatplugin/alipayplugin..
		final PaymentPlugin plugin = findPlugin(payTransactionDto);
		payTransactionDto.getPaymentDto().setPlugin(plugin);

		//save transaction entity
		preProcess(payTransactionDto);

		try {
			executePlugin(payTransactionDto, plugin);
		} catch (Exception e) {
			handleException(e);
		}

		//update transaction entity after execute plugin
		postProcessRequest(payTransactionDto);

		return payTransactionDto;
	}
	
	protected PaymentPlugin findPlugin(DTO payTransactionDto) {
		return null;

	}
	
	public void preProcess(DTO payTransactionDto) {
		// TODO Auto-generated method stub

	}
	
	public abstract void executePlugin(DTO payTransactionDto, PaymentPlugin plugin);

	protected void handleException(Exception e) {
		// TODO Auto-generated method stub

	}
	
	public void postProcessRequest(DTO payTransactionDto) {
		// TODO Auto-generated method stub

	}
	
}
