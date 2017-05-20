package com.future.payment.mapper;

import org.springframework.stereotype.Component;

import com.future.payment.dto.PayDTO;
import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;

@Component
public class PayMapper 
	implements PaymentMapper<PaymentRequest, PaymentResponse, PayDTO> {

	@Override
	public void doValidation(PaymentRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public PayDTO createDto(PaymentRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentResponse mapResponse(PayDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
