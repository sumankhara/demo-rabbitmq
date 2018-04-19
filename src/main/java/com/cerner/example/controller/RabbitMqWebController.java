package com.cerner.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cerner.example.model.Person;
import com.cerner.example.service.Producer;

@RestController
public class RabbitMqWebController {

	@Autowired
	private Producer producer;
	
	@RequestMapping(value = "/produce", method = RequestMethod.POST)
	public String producer(@Valid @RequestBody Person person) {
		
			producer.send(person);

			return "Message sent to the RabbitMQ Successfully";
		}
}
