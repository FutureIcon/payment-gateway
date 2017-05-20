package com.future.payment.kafkaClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.google.gson.Gson;

@Component
public class KafkaTemplateUtil {

	private static Gson gson = new Gson();

	private static final String PAYMENT_REQUEST_TOPIC = "payment_request_topic";

	private static final String PAYMENT_RESPONSE_TOPIC = "payment_response_topic";

	private static final String PAYMENT_TOPIC = "payment_topic";
	
	@Autowired
	private static KafkaTemplate<Integer, String> KAFKA_TEMPLATE;
	
	@Autowired
	public KafkaTemplateUtil(KafkaTemplate<Integer, String> kafkaTemplate) {
		this.KAFKA_TEMPLATE = kafkaTemplate;
	}

	/*public static KafkaTemplate<Integer, String> KAFKA_TEMPLATE = new KafkaTemplate<>(
			new DefaultKafkaProducerFactory<Integer, String>(getProducerProps()));
*/
	public static ListenableFuture<SendResult<Integer, String>> send(String message) {
		return KAFKA_TEMPLATE.send(PAYMENT_TOPIC, message);
	}

	/*private static Map<String, Object> getProducerProps() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.70.33:9092,192.168.70.15:9092,192.168.70.20:9092");
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}*/

	public static ListenableFuture<SendResult<Integer, String>> sendPaymentRequestJson(Object obj) {
		return KAFKA_TEMPLATE.send(PAYMENT_REQUEST_TOPIC, gson.toJson(obj));
	}

	public static ListenableFuture<SendResult<Integer, String>> sendPaymentResponseJson(Object obj) {
		return KAFKA_TEMPLATE.send(PAYMENT_RESPONSE_TOPIC, gson.toJson(obj));
	}

	public static ListenableFuture<SendResult<Integer, String>> sendPaymentJson(Object obj) {
		return KAFKA_TEMPLATE.send(PAYMENT_TOPIC, gson.toJson(obj));
	}
}