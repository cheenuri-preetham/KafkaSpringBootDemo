package com.kafka.springboot.kafka;

import com.kafka.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "demo")
    public void consume(String message){
        log.info("Message Received is {}",message);

    }

    @KafkaListener(topics = "demo_json")
    public void consumeJson(User message){
        log.info("Message Received is {}",message.toString());

    }
}
