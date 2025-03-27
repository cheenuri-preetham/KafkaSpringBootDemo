package com.kafka.springboot.controller;

import com.kafka.springboot.kafka.JsonKafkaProducer;
import com.kafka.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonMessageController {

    @Autowired
    private JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message(User) is Sent to kafka topic");
    }
}
