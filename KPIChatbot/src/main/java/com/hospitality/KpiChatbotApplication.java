package com.hospitality;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KpiChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(KpiChatbotApplication.class, args);
	}

}
