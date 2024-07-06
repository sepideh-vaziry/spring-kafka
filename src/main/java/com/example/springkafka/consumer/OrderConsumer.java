package com.example.springkafka.consumer;

import com.example.springkafka.config.KafkaTopicsConstant;
import com.example.springkafka.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

  @RetryableTopic(
      attempts = "1",
      kafkaTemplate = "kafkaTemplate",
      dltStrategy = DltStrategy.FAIL_ON_ERROR
  )
  @KafkaListener(topics = KafkaTopicsConstant.ORDER_TOPIC, groupId = "myGroup")
  public void consume(Order order) {
    log.info(
        "Consuming the message from {} topic:: {}",
        KafkaTopicsConstant.ORDER_TOPIC,
        order
    );

    if (order.getCount() > 10) {
      throw new IllegalArgumentException("Product count can not be more than 10.");
    }
  }

  @DltHandler
  public void dlOrderHandler(Order order) {
    log.info("The order is consumed by dead-letter topic. The order is: {}", order.toString());
  }

}
