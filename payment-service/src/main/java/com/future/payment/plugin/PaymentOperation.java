package com.future.payment.plugin;

import com.future.payment.dto.PayTransactionDTO;

/**
 * @author cwang12
 * @version 1.0
 * @created 17-Feb-2017 12:44:52 AM
 */
public interface PaymentOperation {

	/**
	 * 
	 * @param request
	 */
	void execute(PayTransactionDTO dto);

}