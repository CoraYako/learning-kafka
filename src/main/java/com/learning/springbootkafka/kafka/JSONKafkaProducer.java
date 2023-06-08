package com.learning.springbootkafka.kafka;

import com.learning.springbootkafka.constants.KafkaConstants;
import com.learning.springbootkafka.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaProducer.class);

    private final KafkaTemplate<String, UserDTO> kafkaTemplate;

    public JSONKafkaProducer(KafkaTemplate<String, UserDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(UserDTO userDTO) {
        LOGGER.info(String.format("Message sent -> %s", userDTO.toString()));

        Message<UserDTO> message = MessageBuilder
                .withPayload(userDTO)
                .setHeader(KafkaHeaders.TOPIC, KafkaConstants.JSON_TOPIC)
                .build();

        kafkaTemplate.send(message);

        return String.format("JSON message sent to Kafka Topic %s -> %s", KafkaConstants.TOPIC_NAME, userDTO.toString());
    }
}
