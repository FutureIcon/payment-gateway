package com.future.payment.bo;

import org.springframework.stereotype.Component;

import com.future.payment.dto.RefundDTO;
import com.future.payment.plugin.PaymentPlugin;

@Component
public class RefundBO extends AbstractBO<RefundDTO> {

	@Override
	public void executePlugin(RefundDTO dto, PaymentPlugin plugin) {
		// TODO Auto-generated method stub
		plugin.executePayDoRefund(dto);
	}

}
