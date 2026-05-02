/** CustomerDAOImpl.java  Nov 12,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Customer;
import com.hospitality.dao.CustomerDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class CustomerDAOImpl extends GenericDAOImpl<Customer> implements CustomerDAO{

}
