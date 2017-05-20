package com.future.payment.mapper;

import org.springframework.stereotype.Component;

import com.future.payment.dto.NotificationDTO;
import com.future.payment.model.NotificationRequest;
import com.future.payment.model.NotificationResponse;

@Component
public class NotificationMapper implements PaymentMapper<NotificationRequest, NotificationResponse, NotificationDTO> {

	@Override
	public void doValidation(NotificationRequest req) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NotificationDTO createDto(NotificationRequest req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotificationResponse mapResponse(NotificationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
