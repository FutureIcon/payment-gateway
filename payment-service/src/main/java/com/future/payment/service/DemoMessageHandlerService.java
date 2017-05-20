package com.future.payment.service;

import com.future.payment.domain.Message;
import com.future.payment.domain.MessageAcknowledgement;

public interface DemoMessageHandlerService {
	MessageAcknowledgement handleMessage(Message message);
}
