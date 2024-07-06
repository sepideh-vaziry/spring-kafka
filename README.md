# Spring Boot Application with Apache Kafka

This project is a simple Spring Boot application integrated with Apache Kafka. 
It demonstrates how to use Kafka for messaging in a Spring Boot application.

![Alt text](https://github.com/sepideh-vaziry/spring-kafka/blob/main/files/kafka.webp?raw=true)

## Features

- Spring Boot for application development
- Apache Kafka for message brokering
- Dead Letter Queue for Kafka
- RESTful endpoints for producing and consuming messages

## Prerequisites

- Java 17 or later
- Apache Kafka
- Maven or Gradle

## Getting Started

1. Install Kafka using docker image.
    ```shell
    docker pull apache/kafka:3.7.1
    ```
   run this docker image:
    ```shell
    docker run -p 9092:9092 -d apache/kafka:3.7.1
    ```
   
2. Run the application.
3. Produce message.
    ```shell
    POST http://localhost:8080/api/v1/orders
    Content-Type: application/json
    
    {
      "productName": "Product 1",
      "count": 10,
      "unitPrice": 10000
    }
    ```
   
4. Consuming Message.
   Messages will be consumed automatically by the Kafka listener configured in the application. 
   You can check the logs to see the consumed messages.
   If the count of product is more than 10 the order published to the dead letter topic.

