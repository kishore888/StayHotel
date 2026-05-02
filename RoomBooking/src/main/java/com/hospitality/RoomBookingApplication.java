package com.hospitality;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;
import com.hospitality.room.booking.client.PaymentClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class RoomBookingApplication {

	@Autowired
	private PaymentClient paymentClient;
	
	public List<PaymentAccount> retrievePaymentList(Hotel hotel) {
		return paymentClient.retrievePaymentList(hotel);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RoomBookingApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
