package com.future.payment.kafka;

import java.util.Map;

import org.junit.Test;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.test.utils.KafkaTestUtils;

public class KafkaTemplateProducerTests {

	private static final String PAYMENT_TOPIC = "jira_event_topic";

	@Test
	public void testTemplate() throws Exception {

		Map<String, Object> senderProps = KafkaTestUtils.senderProps("192.168.70.33:9092,192.168.70.15:9092,192.168.70.20:9092");
		ProducerFactory<Integer, String> pf = new DefaultKafkaProducerFactory<Integer, String>(senderProps);
		KafkaTemplate<Integer, String> template = new KafkaTemplate<>(pf);
		template.setDefaultTopic(PAYMENT_TOPIC);
        for (int i = 0; i < 100; i++) {
        	template.sendDefault(PAYMENT_TOPIC + System.currentTimeMillis());
		}
	}
}
