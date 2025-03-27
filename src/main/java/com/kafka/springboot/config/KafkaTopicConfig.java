package com.kafka.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic demoTopic(){
        return TopicBuilder.name("demo").build();
    }

    @Bean
    public NewTopic demoTopicJson(){
        return TopicBuilder.name("demo_json").build();
    }

}
