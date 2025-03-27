package com.kafka.springboot.kafka;

import com.kafka.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data){
        log.info("message sent is {}",data.toString());
        Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"demo_json").build();
        kafkaTemplate.send(message);
    }
}
