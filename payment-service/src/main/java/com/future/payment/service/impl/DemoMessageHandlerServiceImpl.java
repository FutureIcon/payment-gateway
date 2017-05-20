package com.future.payment.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.future.payment.domain.Message;
import com.future.payment.domain.MessageAcknowledgement;
import com.future.payment.service.DemoMessageHandlerService;

@Service
public class DemoMessageHandlerServiceImpl implements DemoMessageHandlerService {
    private static final Logger logger = LoggerFactory.getLogger(DemoMessageHandlerServiceImpl.class);

    private final String replyMessage = "Pong local " + System.currentTimeMillis();

    @Override
    public MessageAcknowledgement handleMessage(Message message) {
        logger.info("About to Acknowledge");
        return new MessageAcknowledgement(message.getId(), message.getPayload(), this.replyMessage);
    }
}
