/** PaymentDetailsBO.java  Nov 28,19
*/

package com.hospitality.payment.details.bo;

import java.util.List;

import com.hospitality.core.PaymentDetails;

/**
* @author  #Kishore
*/

public interface PaymentDetailsBO {

	public void create(PaymentDetails paymentDetails) throws Exception;
	public List<PaymentDetails> retrieveList() throws Exception;

}
