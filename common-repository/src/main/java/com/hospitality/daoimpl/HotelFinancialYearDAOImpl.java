/** HotelFinancialYearDAOImpl.java  Dec 8,19
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.HotelFinancialYear;
import com.hospitality.dao.HotelFinancialYearDAO;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class HotelFinancialYearDAOImpl extends GenericDAOImpl<HotelFinancialYear> implements HotelFinancialYearDAO{

}
