package com.hospitality.payment.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.Payment;
import com.hospitality.dao.PaymentDAO;
import com.hospitality.payment.bo.PaymentBO;

/**
* @author  #Kishore
*/

@Service("PaymentBO")
@Scope(value="prototype")
public class PaymentBOImpl implements PaymentBO {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public void create(Payment payment) {
		try{
			if(StringUtils.isNotBlank(payment.getPaymentId())){
				paymentDAO.update(payment);
			}else{
				paymentDAO.create(payment);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Payment> retrieveList() {
		List<Payment> paymentList = null;
		try{
			paymentList = paymentDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return paymentList;
	}

}
