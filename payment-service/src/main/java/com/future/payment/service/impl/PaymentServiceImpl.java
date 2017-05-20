package com.future.payment.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.datastax.driver.core.utils.UUIDs;
import com.future.payment.bo.NotificationBO;
import com.future.payment.bo.PayBO;
import com.future.payment.bo.RefundBO;
import com.future.payment.dto.NotificationDTO;
import com.future.payment.dto.PayDTO;
import com.future.payment.dto.RefundDTO;
import com.future.payment.enums.PaymentResult;
import com.future.payment.kafkaClient.KafkaTemplateUtil;
import com.future.payment.mapper.NotificationMapper;
import com.future.payment.mapper.PayMapper;
import com.future.payment.mapper.RefundMapper;
import com.future.payment.model.NotificationRequest;
import com.future.payment.model.NotificationResponse;
import com.future.payment.model.PaymentRequest;
import com.future.payment.model.PaymentResponse;
import com.future.payment.model.RefundRequest;
import com.future.payment.model.RefundResponse;
import com.future.payment.persistence.modeling.PayReqData;
import com.future.payment.persistence.modeling.PaymentRequestKey;
import com.future.payment.persistence.repository.PaymentRequestRepository;
import com.future.payment.persistence.repository.WechatPayReqRepository;
import com.future.payment.plugin.wechat.WechatPay;
import com.future.payment.plugin.wechat.WechatRefund;
import com.future.payment.plugin.wechat.WechatScanQrCodePay;
import com.future.payment.service.PaymentService;
import com.future.payment.wechat.UnifiedPayResData;

//@Service("paymentService")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRequestRepository paymentRequestRepository;

	@Autowired
	private WechatPay wechatPay;

	@Autowired
	private WechatScanQrCodePay wechatScanQrCodePay;

	@Autowired
	private WechatRefund wechatRefund;

	@Autowired
	private PayBO payBO;

	@Autowired
	private RefundBO refundBO;

	@Autowired
	private NotificationBO notificationBO;

	@Autowired
	private PayMapper payMapper;

	@Autowired
	private RefundMapper refundMapper;

	@Autowired
	private NotificationMapper notificationMapper;
	
	@Autowired
	private WechatPayReqRepository wechatPayReqRepository;
	
	@Override
	public PaymentResponse payment(PaymentRequest request) {
		PayDTO dto = payMapper.createDto(request);
		// BeanUtils.copyProperties(request, pluginRequest);
		wechatPay.execute(dto);

		com.future.payment.persistence.modeling.PaymentRequest test = new com.future.payment.persistence.modeling.PaymentRequest();
		if (test.getRequestKey() == null) {
			test.setRequestKey(new PaymentRequestKey(UUIDs.timeBased()));
		}
		//paymentRequestRepository.save(test);

		return new PaymentResponse(PaymentResult.NORMAL);
	}

	@Override
	public String getCodeUrl(PaymentRequest request) {
		try {
			KafkaTemplateUtil.sendPaymentRequestJson(request);
			UnifiedPayResData response = wechatScanQrCodePay.getCodeUrl(request.getOrderNumber());
			KafkaTemplateUtil.sendPaymentResponseJson(response);
			return response.getCode_url();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public PaymentResponse orderQuery(PaymentRequest request) {
		Objects.requireNonNull(request);
		Objects.requireNonNull(request.getOrderNumber());
		String orderNo = request.getOrderNumber();
		try {
			PaymentResponse response = wechatScanQrCodePay.orderQuery(request);
			KafkaTemplateUtil.sendPaymentResponseJson(response);
			List<PayReqData> datas = wechatPayReqRepository.findAllReqWithTradeNo(orderNo);
			if (datas != null) {
				for(PayReqData data: datas){
					data.setTrade_state(response.getTrade_state());
					//wechatPayReqRepository.save(data);
				}
			}
			return response;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public RefundResponse refund(RefundRequest request) {
		RefundDTO dto = refundMapper.createDto(request);
		// BeanUtils.copyProperties(request, pluginRequest);
		wechatRefund.execute(dto);

		com.future.payment.persistence.modeling.PaymentRequest test = new com.future.payment.persistence.modeling.PaymentRequest();
		if (test.getRequestKey() == null) {
			test.setRequestKey(new PaymentRequestKey(UUIDs.timeBased()));
		}
		//paymentRequestRepository.save(test);

		return new RefundResponse(PaymentResult.NORMAL);
	}

	public PaymentResponse pay(PaymentRequest request) {
		payMapper.doValidation(request);
		PayDTO dto = payMapper.createDto(request);
		dto = payBO.processRequest(dto);
		PaymentResponse response = payMapper.mapResponse(dto);
		return response;
	}

	public RefundResponse refund1(RefundRequest request) {
		refundMapper.doValidation(request);
		RefundDTO dto = refundMapper.createDto(request);
		dto = refundBO.processRequest(dto);
		RefundResponse response = refundMapper.mapResponse(dto);
		return response;
	}

	public NotificationResponse notification(NotificationRequest request) {
		notificationMapper.doValidation(request);
		NotificationDTO dto = notificationMapper.createDto(request);
		dto = notificationBO.processRequest(dto);
		NotificationResponse response = notificationMapper.mapResponse(dto);
		return response;
	}

	@Override
	public PaymentResponse getPayment(PaymentRequest request) {
		return null;
	}

}
