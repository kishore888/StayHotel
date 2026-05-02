package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
//@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Customer extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	private String customerId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="door_no")
	private String doorNo;
	
	private String street;
	
	private String state;

	@Column(name="city")
	private String city;

	@Column(name="country")
	private String country;
	
	private String religion;

	@Column(name="email_id")
	private String emailId;

	private String gender;

	@Column(name="id_type")
	private String idType;

	@Column(name="id_value")
	private String idValue;

	private String occupation;

	@Column(name="phone_no1")
	private String phoneNo1;

	@Column(name="phone_no2")
	private String phoneNo2;
	
	@Column(name="path")
	private String path;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Reservation> reservationList = new ArrayList<>(0);
    
	@Transient
	private String customerImage;

	@Transient
	private String paymentType;
	
	@Transient
	private Float totalAmount = 0.0f;
	
	@Transient
	private String paymentAccountId;
	
	public Customer() {
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDoorNo() {
		return this.doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdType() {
		return this.idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdValue() {
		return this.idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhoneNo1() {
		return this.phoneNo1;
	}

	public void setPhoneNo1(String phoneNo1) {
		this.phoneNo1 = phoneNo1;
	}

	public String getPhoneNo2() {
		return this.phoneNo2;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getReligion() {
		return this.religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPaymentAccountId() {
		return paymentAccountId;
	}

	public void setPaymentAccountId(String paymentAccountId) {
		this.paymentAccountId = paymentAccountId;
	}

}