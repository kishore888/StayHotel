/** PaymentGatewayBO.java  Jun 6,19
*/

package com.hospitality.payment.gateway.bo;

import java.util.List;

import com.hospitality.core.PaymentGateway;

/**
* @author  #Kishore
*/

public interface PaymentGatewayBO {

	public void create(PaymentGateway paymentGateway);
	public List<PaymentGateway> retrieveList();

}
