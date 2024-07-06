package com.example.springkafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

  @Bean(KafkaTopicsConstant.ORDER_TOPIC)
  public NewTopic orderTopic() {
    return TopicBuilder
        .name(KafkaTopicsConstant.ORDER_TOPIC)
        .partitions(4)
        .build();
  }

}
