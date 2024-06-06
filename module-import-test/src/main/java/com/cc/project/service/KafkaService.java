package com.cc.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KafkaService {
    @Autowired
    KafkaTemplate kafkaTemplate;

    @Transactional
    public void send(String topic, String message){
        // 异步发送消息
        if (null == kafkaTemplate ) System.out.println("template----Null");

        kafkaTemplate.executeInTransaction(operations -> {
            operations.send(topic, message).addCallback(success -> {
                System.out.println("Message sent successfully!");
            }, failure -> {
                System.err.println("Failed to send message: " + failure.getMessage());
            });
            return 1;
        });
    }

    @Transactional
    public void send2(String topic, String message){
        // 异步发送消息
        if (null == kafkaTemplate ) System.out.println("template----Null");
        kafkaTemplate.send(topic, message).addCallback(success -> {
            System.out.println("Message sent successfully!");
        }, failure -> {
            System.err.println("Failed to send message: " + failure.getMessage());
        });

    }

    @KafkaListener(topics = "test111")
    public void messageHandler(String message){
        System.out.println("Received message: " + message);
    }

}
