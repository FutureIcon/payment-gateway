package com.future.payment.bo;

import org.springframework.stereotype.Component;

import com.future.payment.dto.PayDTO;
import com.future.payment.plugin.PaymentPlugin;

@Component
public class PayBO extends AbstractBO<PayDTO> {

	@Override
	public void executePlugin(PayDTO payDto, PaymentPlugin plugin) {
		// TODO Auto-generated method stub
		plugin.executeDoPay(payDto);
	}

}
