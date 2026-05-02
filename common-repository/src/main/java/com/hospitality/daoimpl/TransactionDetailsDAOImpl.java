/** TransactionDetailsDAOImpl.java  Dec 29,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.TransactionDetails;
import com.hospitality.dao.TransactionDetailsDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class TransactionDetailsDAOImpl extends GenericDAOImpl<TransactionDetails> implements TransactionDetailsDAO{

}
