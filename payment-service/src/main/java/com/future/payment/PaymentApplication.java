package com.future.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
//@EntityScan(basePackages = "com.future.payment.persistence.modeling")
public class PaymentApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }
}
