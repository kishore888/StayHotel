/** PaymentDetailsBOImpl.java  Nov 28,19
*/

package com.hospitality.payment.details.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.PaymentDetails;
import com.hospitality.dao.PaymentDetailsDAO;
import com.hospitality.payment.details.bo.PaymentDetailsBO;

/**
* @author  #Kishore
*/

@Service("PaymentDetailsBO")
@Scope(value="prototype")
public class PaymentDetailsBOImpl implements PaymentDetailsBO{

	@Autowired
	private PaymentDetailsDAO paymentDetailsDAO;
	
	@Override
	public void create(PaymentDetails paymentDetails) {
		try{
			if(StringUtils.isNotBlank(paymentDetails.getPaymentDetailsId())){
				paymentDetailsDAO.update(paymentDetails);
			}else{
				paymentDetailsDAO.create(paymentDetails);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<PaymentDetails> retrieveList() {
		List<PaymentDetails> paymentDetailsList = null;
		try{
			paymentDetailsList = paymentDetailsDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return paymentDetailsList;
	}

}
