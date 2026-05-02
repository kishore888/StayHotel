/** PaymentGatewayBOImpl.java  Jun 6,19
*/

package com.hospitality.payment.gateway.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.PaymentGateway;
import com.hospitality.dao.PaymentGatewayDAO;
import com.hospitality.payment.gateway.bo.PaymentGatewayBO;

/**
* @author  #Kishore
*/

@Service("PaymentGatewayBO")
@Scope(value="prototype")
public class PaymentGatewayBOImpl implements PaymentGatewayBO{

	@Autowired
	private PaymentGatewayDAO paymentGatewayDAO;
	
	@Override
	public void create(PaymentGateway paymentGateway) {
		try{
			if(StringUtils.isNotBlank(paymentGateway.getPaymentGatewayId())){
				paymentGatewayDAO.update(paymentGateway);
			}else{
				paymentGatewayDAO.create(paymentGateway);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<PaymentGateway> retrieveList() {
		List<PaymentGateway> paymentGatewayList = null;
		try{
			paymentGatewayList = paymentGatewayDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return paymentGatewayList;
	}

}
