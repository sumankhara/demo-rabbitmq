package com.cerner.example.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@RabbitListener(queues = "eligrqst.queue")
	public void receiveMessage(final Message message) {
//        log.info("Received message as generic: {}", message.toString());
		System.out.println("Received message as generic: " + message.toString());
    }
}
