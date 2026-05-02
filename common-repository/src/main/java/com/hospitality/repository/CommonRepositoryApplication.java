package com.hospitality.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableDiscoveryClient
public class CommonRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonRepositoryApplication.class, args);
	}

}
