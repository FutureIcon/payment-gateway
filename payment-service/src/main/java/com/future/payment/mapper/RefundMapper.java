package com.future.payment.mapper;

import org.springframework.stereotype.Component;

import com.future.payment.dto.RefundDTO;
import com.future.payment.model.RefundRequest;
import com.future.payment.model.RefundResponse;

@Component
public class RefundMapper implements PaymentMapper<RefundRequest, RefundResponse, RefundDTO> {

	@Override
	public void doValidation(RefundRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RefundDTO createDto(RefundRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RefundResponse mapResponse(RefundDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
