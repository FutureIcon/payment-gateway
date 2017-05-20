package com.future.payment.bo;

import org.springframework.stereotype.Component;

import com.future.payment.dto.NotificationDTO;
import com.future.payment.plugin.PaymentPlugin;

@Component
public class NotificationBO extends AbstractBO<NotificationDTO> {

	@Override
	public void executePlugin(NotificationDTO dto, PaymentPlugin plugin) {
		// TODO Auto-generated method stub
		plugin.executePayNotification(dto);
	}

}
