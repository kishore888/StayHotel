/** PaymentAccountBOImpl.java  Dec 8,19
*/

package com.hospitality.payment.account.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.Hotel;
import com.hospitality.core.PaymentAccount;
import com.hospitality.dao.PaymentAccountDAO;
import com.hospitality.payment.account.bo.PaymentAccountBO;

/**
* @author  #Kishore
*/

@Service("PaymentAccountBO")
@Scope(value="prototype")
public class PaymentAccountBOImpl implements PaymentAccountBO{

	@Autowired
	private PaymentAccountDAO paymentAccountDAO;
	
	@Override
	public void create(PaymentAccount paymentAccount) throws Exception{
		try{
			if(StringUtils.isNotBlank(paymentAccount.getPaymentAccountId())){
				paymentAccountDAO.update(paymentAccount);
			}else{
				paymentAccountDAO.create(paymentAccount);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<PaymentAccount> retrieveList() throws Exception{
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
			paymentAccountList = paymentAccountDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return paymentAccountList;
	}

	@Override
	public PaymentAccount retrieveById(String paymentAccountId) throws Exception {
		PaymentAccount paymentAccount = null;
		try{
			paymentAccount = paymentAccountDAO.retrieveByPaymentAccountId(paymentAccountId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return paymentAccount;
	}

	@Override
	public List<PaymentAccount> retrieveListByHotel(Hotel hotel) throws Exception {
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
			paymentAccountList = paymentAccountDAO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return paymentAccountList;
	}

	@Override
	public void delete(PaymentAccount paymentAccount) throws Exception {
		try{
			paymentAccount = paymentAccountDAO.findById(paymentAccount.getPaymentAccountId());
//			paymentAccountDAO.delete(paymentAccount.getPaymentAccountId());
			paymentAccountDAO.delete(paymentAccount);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
