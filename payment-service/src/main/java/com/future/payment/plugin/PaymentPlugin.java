package com.future.payment.plugin;

import com.future.payment.dto.PayTransactionDTO;

/**
 * @author cwang12
 * @version 1.0
 * @created 17-Feb-2017 12:44:52 AM
 */
public interface PaymentPlugin {


	/**
	 * 
	 * @param req
	 */
	public void executeDoPay(PayTransactionDTO dto);

	/**
	 * 
	 * @param request
	 */
	public void executePayDoRefund(PayTransactionDTO dto);

	/**
	 * 
	 * @param request
	 */
	public void executePayNotification(PayTransactionDTO dto);

	/**
	 * 
	 * @param result
	 * @param resultReason
	 * @param transactionType
	 */
	public boolean isRedoRequired(String result, String resultReason, String transactionType);

}