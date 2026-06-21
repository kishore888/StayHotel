package com.hospitality.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class Employee extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="employee_id")
	private String employeeId;

	@Column(name="audhar_card_no")
	private String audharCardNo;

	@Column(name="correspondence_address")
	private String correspondenceAddress;

	@Column(name="cur_city")
	private String curCity;

	@Column(name="cur_state")
	private String curState;

	@Column(name="cur_street")
	private String curStreet;

	@Column(name="driving_licence_no")
	private String drivingLicenceNo;

	@Column(name="email_id")
	private String emailId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="father_name")
	private String fatherName;

	@Column(name="gender")
	private String gender;

	@Column(name="image")
	private String image;

	@Column(name="marital_status")
	private Boolean maritalStatus;

	@Column(name="pan_number")
	private String panNumber;

	@Column(name="passport_no")
	private String passportNo;

	@Column(name="permanent_address")
	private String permanentAddress;

	@Column(name="permnt_city")
	private String permntCity;

	@Column(name="permnt_state")
	private String permntState;

	@Column(name="permnt_street")
	private String permntStreet;

	@Column(name="prefix")
	private String prefix;

	@Column(name="qualification")
	private String qualification;

	@Column(name="religion")
	private String religion;

	@Column(name="voter_id")
	private String voterId;

	@Column(name="phone")
	private String phone;

	@Column(name="role")
	private String role;

	@Column(name="department")
	private String department;

	@Column(name="salary")
	private BigDecimal salary;

	@Temporal(TemporalType.DATE)
	@Column(name="joining_date")
	private Date joiningDate;

	@Column(name="status")
	private String status;

	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	public Employee() {
	}

}