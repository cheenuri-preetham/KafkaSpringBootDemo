package com.kafka.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("Message Sent %s",message));
        kafkaTemplate.send("demo",message);
    }

}
