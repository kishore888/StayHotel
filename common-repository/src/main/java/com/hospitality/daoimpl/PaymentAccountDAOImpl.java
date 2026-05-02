/** PaymentAccountDAOImpl.java  Dec 8,19
*/

package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;
import com.hospitality.dao.PaymentAccountDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class PaymentAccountDAOImpl extends GenericDAOImpl<PaymentAccount> implements PaymentAccountDAO{

	@Override
	public PaymentAccount retrieveByPaymentAccountId(String paymentAccountId) throws Exception {
		PaymentAccount paymentAccount = null;
		try {
			String queryString = "select pa from PaymentAccount pa join fetch pa.hotelPaymentGateway where pa.paymentAccountId=:paymentAccountId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("paymentAccountId", paymentAccountId);
			if(query.getResultList().size()>0) {
				paymentAccount = (PaymentAccount) query.getResultList().get(0);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return paymentAccount;
	}

	@Override
	public List<PaymentAccount> retrieveListByHotel(Hotel hotel) throws Exception {
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try {
			String queryString = "select pa from PaymentAccount pa join fetch pa.hotelPaymentGateway pg join fetch pg.paymentGateway join pg.hotel h where h.hotelId=:hotelId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelId", hotel.getHotelId());
			paymentAccountList = query.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return paymentAccountList;
	}

}
