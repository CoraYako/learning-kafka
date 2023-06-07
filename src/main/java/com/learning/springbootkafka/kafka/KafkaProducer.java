package com.learning.springbootkafka.kafka;

import com.learning.springbootkafka.constants.KafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(String message) {
        log.info(String.format("Message sent %s", message));
        kafkaTemplate.send(KafkaConstants.TOPIC_NAME, message);
        return String.format("Message sent %s", message);
    }
}
