package com.learning.springbootkafka.controller;

import com.learning.springbootkafka.constants.KafkaConstants;
import com.learning.springbootkafka.kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(KafkaConstants.BASE_URL)
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping(KafkaConstants.PUBLISH_URI)
    public ResponseEntity<String> publish(@RequestParam(KafkaConstants.PUBLISH_URI_REQUEST_PARAM) String message) {
        return ResponseEntity.status(HttpStatus.OK).body(kafkaProducer.sendMessage(message));
    }
}
