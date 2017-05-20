package com.future.payment.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.future.payment.enums.PaymentResult;
import com.future.payment.model.BasePaymentResponse;
import com.future.payment.model.FieldErrorPaymentResponse;
import com.future.payment.model.NotificationRequest;
import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;
import com.future.payment.model.RefundRequest;
import com.future.payment.service.PaymentService;

@RestController
public class PaymentLifeCycleController {

//	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = "/testPayment", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String testPayment(@RequestBody PaymentRequest request, BindingResult result) {
		return "testPayment" + System.currentTimeMillis();
	}

	/**
	 * Process all the payment requests.
	 * 
	 * @param request
	 * @return PaymentResponse
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse payment(@Valid @RequestBody PaymentRequest request, BindingResult result) {
		BasePaymentResponse response = null;
		if (result.hasErrors()) {
			response = new FieldErrorPaymentResponse(PaymentResult.VALID_ERROR);
			return response;
		}
		response = new BasePaymentResponse(PaymentResult.NORMAL); // paymentService.payment(request);
		return response;
	}

	@RequestMapping(value = "/qrcodeurl", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String getQrCodeUrl(@RequestBody PaymentRequest request, BindingResult result) {
		String codeUrl = paymentService.getCodeUrl(request);
		return codeUrl;
	}

	/**
	 * Return the status of payment
	 * 
	 * @param request
	 * @param result
	 * @return BasePaymentResponse
	 */
	@RequestMapping(value = "/payment/{tradeNo}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public PaymentResponse paymentStatus(@PathVariable String tradeNo) {
		PaymentRequest request = new PaymentRequest();
		request.setOrderNumber(tradeNo);
		PaymentResponse response = paymentService.orderQuery(request);
		return response;
	}

	/**
	 * Process payment refund.
	 * 
	 * @param request
	 * @return PaymentResponse
	 */
	@RequestMapping(value = "/refund", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse refund(@Valid @RequestBody RefundRequest request, BindingResult result) {
		BasePaymentResponse response = null;
		if (result.hasErrors()) {
			response = new FieldErrorPaymentResponse(PaymentResult.VALID_ERROR);
			return response;
		}
		response = paymentService.refund(request);
		return response;
	}

	/**
	 * @param paymentId
	 * @return PaymentResourceResponse
	 */
	@RequestMapping(value = "/payment", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse getPayment(String paymentId) {
		BasePaymentResponse response = new FieldErrorPaymentResponse(PaymentResult.NORMAL);
		return response;
	}

	/**
	 * @param transactionId
	 * @return
	 */
	@RequestMapping(value = "/transaction", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse getTransaction(String transactionId) {
		BasePaymentResponse response = new FieldErrorPaymentResponse(PaymentResult.NORMAL);
		return response;
	}

	/**
	 * @param zone
	 * @return
	 */
	@RequestMapping(value = "/paymentMethod", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse listMethods(String zone) {
		BasePaymentResponse response = new FieldErrorPaymentResponse(PaymentResult.NORMAL);
		return response;
	}

	/**
	 * @param notificationRequest
	 * @return
	 */
	@RequestMapping(value = "/notification", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public BasePaymentResponse notification(NotificationRequest notificationRequest) {
		BasePaymentResponse response = new FieldErrorPaymentResponse(PaymentResult.NORMAL);
		return response;
	}
}