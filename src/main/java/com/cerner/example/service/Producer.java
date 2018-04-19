package com.cerner.example.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cerner.example.model.Person;

@Service
public class Producer {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("amq.direct")
	private String exchange;
	
	@Value("eligrqst.routingkey")
	private String routingkey;	
	
	public void send(Person person) {
		rabbitTemplate.convertAndSend(exchange, routingkey, person);
		System.out.println("Send msg = " + person);
	    
	}
}
