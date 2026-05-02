/** FinancialYearDAOImpl.java  Dec 8,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.FinancialYear;
import com.hospitality.dao.FinancialYearDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class FinancialYearDAOImpl extends GenericDAOImpl<FinancialYear> implements FinancialYearDAO{

}
