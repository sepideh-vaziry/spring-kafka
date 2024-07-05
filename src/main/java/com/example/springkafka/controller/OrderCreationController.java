package com.example.springkafka.controller;

import com.example.springkafka.dto.Order;
import com.example.springkafka.service.OrderCreationService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderCreationController {

  private final OrderCreationService orderCreationService;

  @PostMapping
  public ResponseEntity<Boolean> createOrder(
      @RequestBody Order order
  ) {
    orderCreationService.create(order);

    return ResponseEntity.ok().build();
  }

}
