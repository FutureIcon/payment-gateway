package com.future.payment.advice;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.future.payment.enums.PaymentResult;
import com.future.payment.model.BasePaymentResponse;

@ControllerAdvice(annotations = RestController.class)
@Order(0)
public class RestControllerAdvice {

	@ResponseBody
	@ExceptionHandler(value = { RuntimeException.class, Exception.class })
	public BasePaymentResponse handleWebServiceException(Exception e, HttpServletRequest req) {
		BasePaymentResponse result = new BasePaymentResponse(PaymentResult.INTERNAL_SERVER_ERROR);
		result.setHttpStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		return result;
	}
}
