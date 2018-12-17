package com.example.addservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name="AddService", configuration = RibbonConfiguration.class)
public class AddserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddserviceApplication.class, args);
	}

}

