package com.future.payment.plugin;

public abstract class AbstractPaymentPlugin implements PaymentPlugin {

	public AbstractPaymentPlugin(){}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param result
	 * @param resultReason
	 * @param transactionType
	 */
	@Override
	public boolean isRedoRequired(String result, String resultReason, String transactionType){
		return false;
	}

}//end AbstractPaymentPlugin