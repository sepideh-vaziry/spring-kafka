package com.example.springkafka.consumer;

import com.example.springkafka.config.KafkaTopicsConstant;
import com.example.springkafka.dto.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

  @KafkaListener(topics = KafkaTopicsConstant.TOPIC_ORDER, groupId = "myGroup")
  public void consume(Order order) {
    log.info(
        "Consuming the message from {} topic:: {}",
        KafkaTopicsConstant.TOPIC_ORDER,
        order
    );
  }

}
