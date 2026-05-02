/** TransactionDetailsBO.java  Dec 29,19
*/

package com.hospitality.payment.transaction.bo;

import java.util.List;

import com.hospitality.core.TransactionDetails;

/**
* @author  #Kishore
*/

public interface TransactionDetailsBO {

	public void create(TransactionDetails transactionDetails) throws Exception;
	public List<TransactionDetails> retrieveList() throws Exception;

}
