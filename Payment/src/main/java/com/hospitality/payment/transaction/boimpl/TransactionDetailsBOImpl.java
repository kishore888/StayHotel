/** TransactionDetailsBOImpl.java  Dec 29,19
*/

package com.hospitality.payment.transaction.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.TransactionDetails;
import com.hospitality.dao.TransactionDetailsDAO;
import com.hospitality.payment.transaction.bo.TransactionDetailsBO;

/**
* @author  #Kishore
*/

@Service("TransactionDetailsBO")
@Scope(value="prototype")
public class TransactionDetailsBOImpl implements TransactionDetailsBO{

	@Autowired
	private TransactionDetailsDAO transactionDetailsDAO;
	
	@Override
	public void create(TransactionDetails transactionDetails) {
		try{
			if(StringUtils.isNotBlank(transactionDetails.getTransactionDetailsId())){
				transactionDetailsDAO.update(transactionDetails);
			}else{
				transactionDetailsDAO.create(transactionDetails);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<TransactionDetails> retrieveList() {
		List<TransactionDetails> transactionDetailsList = null;
		try{
			transactionDetailsList = transactionDetailsDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return transactionDetailsList;
	}

}
