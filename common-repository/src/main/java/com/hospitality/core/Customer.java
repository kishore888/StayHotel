package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

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
@Data
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

}