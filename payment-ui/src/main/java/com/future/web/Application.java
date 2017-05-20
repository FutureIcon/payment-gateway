package com.future.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/*@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@RibbonClients({ @RibbonClient(name = "samplepongdirect")})*/
@EnableOAuth2Sso
public class Application {
	    @Bean
	    public RestOperations nonLoadbalancedRestTemplate() {
	        return new RestTemplate();
	    }

	    @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
