package com.future.payment.mapper;

import com.future.payment.dto.PayTransactionDTO;
import com.future.payment.model.BasePaymentRequest;
import com.future.payment.model.BasePaymentResponse;

public interface PaymentMapper<REQ extends BasePaymentRequest, RES extends BasePaymentResponse, DTO extends PayTransactionDTO> {
	
	void doValidation(REQ req);

	DTO createDto(REQ req);

	/**
	 * Map response.
	 * 
	 * @param response
	 *            the response
	 * @return the sres
	 */
	RES mapResponse(DTO dto);

}
