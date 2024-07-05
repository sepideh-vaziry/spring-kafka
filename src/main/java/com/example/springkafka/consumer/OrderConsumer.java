package com.example.springkafka.consumer;

import com.example.springkafka.config.KafkaTopics;
import com.example.springkafka.dto.Order;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderConsumer {

  @KafkaListener(topics = KafkaTopics.TOPIC_ORDER, groupId = "myGroup")
  public void consume(Order order) {
    log.info(
        "Consuming the message from {} topic:: {}",
        KafkaTopics.TOPIC_ORDER,
        order
    );
  }

}
