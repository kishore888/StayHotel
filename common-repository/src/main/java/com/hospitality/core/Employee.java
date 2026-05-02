package com.hospitality.core;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
//@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
@JsonIdentityInfo(generator = JSOGGenerator.class)
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

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getAudharCardNo() {
		return this.audharCardNo;
	}

	public void setAudharCardNo(String audharCardNo) {
		this.audharCardNo = audharCardNo;
	}

	public String getCorrespondenceAddress() {
		return this.correspondenceAddress;
	}

	public void setCorrespondenceAddress(String correspondenceAddress) {
		this.correspondenceAddress = correspondenceAddress;
	}

	public String getCurCity() {
		return this.curCity;
	}

	public void setCurCity(String curCity) {
		this.curCity = curCity;
	}

	public String getCurState() {
		return this.curState;
	}

	public void setCurState(String curState) {
		this.curState = curState;
	}

	public String getCurStreet() {
		return this.curStreet;
	}

	public void setCurStreet(String curStreet) {
		this.curStreet = curStreet;
	}

	public String getDrivingLicenceNo() {
		return this.drivingLicenceNo;
	}

	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(Boolean maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPermanentAddress() {
		return this.permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermntCity() {
		return this.permntCity;
	}

	public void setPermntCity(String permntCity) {
		this.permntCity = permntCity;
	}

	public String getPermntState() {
		return this.permntState;
	}

	public void setPermntState(String permntState) {
		this.permntState = permntState;
	}

	public String getPermntStreet() {
		return this.permntStreet;
	}

	public void setPermntStreet(String permntStreet) {
		this.permntStreet = permntStreet;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getReligion() {
		return this.religion;
	}

public String getVoterId() {
    return this.voterId;
}

public void setVoterId(String voterId) {
    this.voterId = voterId;
}

public String getPhone() {
    return this.phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getRole() {
    return this.role;
}

public void setRole(String role) {
    this.role = role;
}

public String getDepartment() {
    return this.department;
}

public void setDepartment(String department) {
    this.department = department;
}

public BigDecimal getSalary() {
    return this.salary;
}

public void setSalary(BigDecimal salary) {
    this.salary = salary;
}

public Date getJoiningDate() {
    return this.joiningDate;
}

public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
}

public String getStatus() {
    return this.status;
}

public void setStatus(String status) {
    this.status = status;
}

public Hotel getHotel() {
    return hotel;
}

public void setHotel(Hotel hotel) {
    this.hotel = hotel;
}

}