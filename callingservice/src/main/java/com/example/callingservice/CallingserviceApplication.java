package com.example.callingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CallingserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CallingserviceApplication.class, args);
	}

}

