package com.hospitality.employee.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.Employee;
import com.hospitality.dao.EmployeeDAO;
import com.hospitality.employee.bo.EmployeeBO;

@Service("EmployeeBO")
@Scope(value = "prototype")
public class EmployeeBOImpl implements EmployeeBO {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public List<Employee> retrieveByHotelId(String hotelId) throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeeDAO.retrieveEmployeeList(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return employeeList;
	}

	@Override
	public Employee retrieveById(String employeeId) throws Exception {
		Employee employee = null;
		try {
			employee = employeeDAO.findById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return employee;
	}

	@Override
	public void create(Employee employee) throws Exception {
		try {
			if (StringUtils.isNotBlank(employee.getEmployeeId())) {
				employeeDAO.update(employee);
			} else {
				employeeDAO.create(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(Employee employee) throws Exception {
		try {
			employeeDAO.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(String employeeId) throws Exception {
		try {
			employeeDAO.deleteAndCommit(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
