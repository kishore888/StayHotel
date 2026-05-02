/** PaymentAccountBO.java  Dec 8,19
*/

package com.hospitality.payment.account.bo;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;

/**
* @author  #Kishore
*/

public interface PaymentAccountBO {

	public void create(PaymentAccount paymentAccount) throws Exception;
	public List<PaymentAccount> retrieveList() throws Exception;
	public PaymentAccount retrieveById(String paymentAccountId) throws Exception;
	public List<PaymentAccount> retrieveListByHotel(Hotel hotel) throws Exception;
	public void delete(PaymentAccount paymentAccount) throws Exception;

}
