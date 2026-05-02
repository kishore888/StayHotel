/** PaymentDetailsDAOImpl.java  Nov 28,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.PaymentDetails;
import com.hospitality.dao.PaymentDetailsDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class PaymentDetailsDAOImpl extends GenericDAOImpl<PaymentDetails> implements PaymentDetailsDAO{

}
