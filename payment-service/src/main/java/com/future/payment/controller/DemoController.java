package com.future.payment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.payment.domain.Message;
import com.future.payment.domain.MessageAcknowledgement;
import com.future.payment.service.DemoMessageHandlerService;

@RestController
public class DemoController {

    private final DemoMessageHandlerService messageHandlerService;

    @Autowired
    public DemoController(DemoMessageHandlerService messageHandlerService) {
        this.messageHandlerService = messageHandlerService;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public Resource<MessageAcknowledgement> pongMessage(@RequestBody Message input) {
        return new Resource<>(this.messageHandlerService.handleMessage(input));
    }

}
