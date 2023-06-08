package com.learning.springbootkafka.controller;

import com.learning.springbootkafka.constants.KafkaConstants;
import com.learning.springbootkafka.kafka.JSONKafkaProducer;
import com.learning.springbootkafka.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(KafkaConstants.BASE_URL)
@RequiredArgsConstructor
public class JSONMessageController {

    private final JSONKafkaProducer kafkaProducer;

    @PostMapping(KafkaConstants.PUBLISH_URI)
    public ResponseEntity<String> publish(@RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(kafkaProducer.sendMessage(userDTO));
    }
}
