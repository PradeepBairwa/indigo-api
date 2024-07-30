package com.indigo.service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightStatusConsumerService {

    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();



    public String getLatestMessage() {
        return messageQueue.poll();
    }
    
    @Autowired
    private SimpMessagingTemplate template;

    @KafkaListener(topics = "flight-status", groupId = "flight-status-group")
    public void listen(ConsumerRecord<String, String> record) {
    	 messageQueue.offer(record.value());
        String message = record.value();
        template.convertAndSend("/topic/flight-status", message);
    }
}
