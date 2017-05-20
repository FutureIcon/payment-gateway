package com.future.payment.bo;

import org.springframework.stereotype.Component;

@Component
public interface PaymentBO<DTO> {

	public DTO processRequest(DTO dto);

}
