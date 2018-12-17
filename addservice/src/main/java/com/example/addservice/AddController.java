package com.example.addservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@GetMapping(value="add/{num1}/{num2}")
	public String add(@PathVariable(value="num1") int number1, @PathVariable(value="num2") int number2){
		System.out.println("Service Registered : " + discoveryClient.getInstances("add-service").get(0));
		return String.valueOf(number1+number2);
	}
}
