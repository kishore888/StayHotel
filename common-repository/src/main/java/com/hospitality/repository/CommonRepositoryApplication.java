package com.hospitality.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Profile("standalone")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
//@EnableDiscoveryClient
public class CommonRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonRepositoryApplication.class, args);
	}

}
