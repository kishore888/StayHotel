package com.hospitality.employee.bo;

import java.util.List;

import com.hospitality.core.Employee;

public interface EmployeeBO {

	public List<Employee> retrieveByHotelId(String hotelId) throws Exception;
	public Employee retrieveById(String employeeId) throws Exception;
	public void create(Employee employee) throws Exception;
	public void update(Employee employee) throws Exception;
	public void delete(String employeeId) throws Exception;

}
