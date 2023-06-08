package com.learning.springbootkafka.kafka;

import com.learning.springbootkafka.constants.KafkaConstants;
import com.learning.springbootkafka.model.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JSONKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONKafkaConsumer.class);

    @KafkaListener(topics = KafkaConstants.JSON_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void consume(UserDTO userDTO) {
        LOGGER.info(String.format("Json message received -> %s", userDTO.toString()));
    }
}
