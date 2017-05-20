package com.future.payment.kafka;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Test;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

public class KafkaTemplateConsumerTests {

	private static final String PAYMENT_TOPIC = "event_topic";

	@Test
	public void testTemplate() throws Exception {
		Map<String, Object> consumerProps = consumerProps("", "", "false");
		
		DefaultKafkaConsumerFactory<String, String> cf = new DefaultKafkaConsumerFactory<String, String>(consumerProps);
		//ContainerProperties containerProperties = new ContainerProperties(PAYMENT_TOPIC);
		//KafkaMessageListenerContainer<String, String> container = new KafkaMessageListenerContainer<>(cf, containerProperties);
		/*final BlockingQueue<ConsumerRecord<Integer, String>> records = new LinkedBlockingQueue<>();
		container.setupMessageListener(new MessageListener<Integer, String>() {

			@Override
			public void onMessage(ConsumerRecord<Integer, String> record) {
				System.out.println(record);
				records.add(record);
			}
		});
		container.setBeanName("templateTests");*/
		//container.start();
		Consumer<String, String> consumer = cf.createConsumer();
		consumer.subscribe(Arrays.asList(PAYMENT_TOPIC));
		TopicPartition topic = new TopicPartition(PAYMENT_TOPIC, 0);
		//consumer.assign(Arrays.asList(topic));
		//consumer.seekToEnd(Arrays.asList(topic));
		ConsumerRecords<String, String> consumerRecords = consumer.poll(100000);
		Iterator<ConsumerRecord<String,String>> it = consumerRecords.records(PAYMENT_TOPIC).iterator();
		while(it.hasNext()){
			ConsumerRecord<String,String> record = it.next();
			System.out.println(record.value());
		}
		consumer.commitSync();
		/*TopicPartition topic = new TopicPartition(PAYMENT_TOPIC, 0);
		System.out.println(consumer.committed(topic));*/
		System.out.println("");
	}
	
	
	public static Map<String, Object> consumerProps(String brokers, String group, String autoCommit) {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, group);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "3");
		props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "104857600");
		return props;
	}
}