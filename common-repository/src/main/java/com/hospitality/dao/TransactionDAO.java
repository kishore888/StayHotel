/** TransactionDAO.java  Nov 10,19
*/

package com.hospitality.dao;

import com.hospitality.core.Transaction;

/**
* @author  Kishore
*/

public interface TransactionDAO extends GenericDAO<Transaction>{

	public Transaction retrieveByClientTransactionNo(String clientTransactionNo) throws Exception;

}
