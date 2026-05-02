/** PaymentDAOImpl.java  Nov 28,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Payment;
import com.hospitality.dao.PaymentDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class PaymentDAOImpl extends GenericDAOImpl<Payment> implements PaymentDAO{

}
