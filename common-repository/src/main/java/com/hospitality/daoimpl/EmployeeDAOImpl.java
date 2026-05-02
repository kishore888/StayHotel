/** EmployeeDAOImpl.java  Oct 31,17
*/

package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Employee;
import com.hospitality.dao.EmployeeDAO;

import jakarta.persistence.Query;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements EmployeeDAO{

    @Override
	public List<Employee> retrieveEmployeeList(String hotelId) throws Exception{
		List<Employee> employeeList = new ArrayList<>();
		try{
			String queryString = "Select r from Employee r join fetch r.hotel h where h.hotelId=:hotelId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelId", hotelId);
			employeeList = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return employeeList;
	}
}
