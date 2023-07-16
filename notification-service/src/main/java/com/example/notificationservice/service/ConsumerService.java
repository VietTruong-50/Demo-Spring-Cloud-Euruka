package com.example.notificationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "orderTopic", groupId = "vietphale")
    public void consume(String message) {
        log.info(String.format("Inventory => Consumed message: %s", message));
    }
}
