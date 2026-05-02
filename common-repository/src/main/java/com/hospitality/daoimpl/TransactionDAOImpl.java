/** TransactionDAOImpl.java  Nov 10,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Transaction;
import com.hospitality.dao.TransactionDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class TransactionDAOImpl extends GenericDAOImpl<Transaction> implements TransactionDAO{

	@Override
	public Transaction retrieveByClientTransactionNo(String clientTransactionNo) throws Exception {
		Transaction transaction = null;
		try{
			String queryString = "Select t from Transaction t left join fetch t.paymentDetails join fetch t.customer join fetch t.paymentAccount where t.clientTransactionNo=:clientTransactionNo";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("clientTransactionNo", clientTransactionNo);
			if(query.getResultList().size() > 0) {
				transaction = (Transaction) query.getSingleResult();
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return transaction;
	}

}
