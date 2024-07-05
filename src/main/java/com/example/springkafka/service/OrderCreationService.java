package com.example.springkafka.service;

import com.example.springkafka.config.KafkaTopics;
import com.example.springkafka.dto.Order;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderCreationService {

  private final KafkaTemplate<String, Order> kafkaTemplate;

  public void create(Order order) {
    Message<Order> message = MessageBuilder
        .withPayload(order)
        .setHeader(KafkaHeaders.TOPIC, KafkaTopics.TOPIC_ORDER)
        .build();

    kafkaTemplate.send(message);
  }
}
