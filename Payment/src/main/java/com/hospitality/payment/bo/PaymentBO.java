package com.hospitality.payment.bo;

import java.util.List;

import com.hospitality.core.Payment;

/**
* @author  #Kishore
*/

public interface PaymentBO {

	public void create(Payment payment) throws Exception;
	public List<Payment> retrieveList() throws Exception;

}