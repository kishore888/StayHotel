package com.hospitality.room.booking.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;

@FeignClient(url="PAYMENT_SERVICE",name="PAYMENT-SERVICE")
public interface PaymentClient {

	@GetMapping("/retrievePaymentList")
	public List<PaymentAccount> retrievePaymentList(Hotel hotel);
}
