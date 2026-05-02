/** PaymentGatewayDAOImpl.java  Jun 6,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.PaymentGateway;
import com.hospitality.dao.PaymentGatewayDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class PaymentGatewayDAOImpl extends GenericDAOImpl<PaymentGateway> implements PaymentGatewayDAO{

}
