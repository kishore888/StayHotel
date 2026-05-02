/** PaymentAccountDAO.java  Dec 8,19
*/

package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;

/**
* @author  #Kishore
*/

public interface PaymentAccountDAO extends GenericDAO<PaymentAccount>{

	public PaymentAccount retrieveByPaymentAccountId(String paymentAccountId) throws Exception;

	public List<PaymentAccount> retrieveListByHotel(Hotel hotel) throws Exception;

}
