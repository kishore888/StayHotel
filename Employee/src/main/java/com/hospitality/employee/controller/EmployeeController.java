package com.hospitality.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.core.Employee;
import com.hospitality.employee.bo.EmployeeBO;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeBO employeeBO;

	@GetMapping(value = "/list", produces = "application/json")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam(value = "hotelId") String hotelId) {
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeeBO.retrieveByHotelId(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(employeeList);
	}

	@GetMapping(value = "/{employeeId}", produces = "application/json")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
		Employee employee = null;
		try {
			employee = employeeBO.retrieveById(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(employee);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			employeeBO.create(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(employee);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		try {
			employeeBO.update(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping(value = "/delete/{employeeId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable String employeeId) {
		try {
			employeeBO.delete(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok().build();
	}

}
