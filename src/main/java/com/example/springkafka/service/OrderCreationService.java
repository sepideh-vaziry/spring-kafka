package com.example.springkafka.service;

import com.example.springkafka.config.KafkaTopicsConstant;
import com.example.springkafka.dto.Order;
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
        .setHeader(KafkaHeaders.TOPIC, KafkaTopicsConstant.ORDER_TOPIC)
        .build();

    kafkaTemplate.send(message);
  }
}
