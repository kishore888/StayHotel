/** EmployeeDAO.java  Oct 31,17
*/

package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Employee;

/**
* @author  Kishore
*/

public interface EmployeeDAO extends GenericDAO<Employee>{

    public List<Employee> retrieveEmployeeList(String hotelId) throws Exception;

}
