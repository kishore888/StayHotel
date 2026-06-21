package com.hospitality.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
//@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
@JsonIdentityInfo(generator = JSOGGenerator.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "hotelId")
@JsonInclude(Include.NON_NULL)
@Data
public class Hotel extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hotel_id")
	private String hotelId;

	@Column(name="city")
	private String city;

	@Column(name="district")
	private String district;

	@Column(name="email_id")
	private String emailId;

	@Column(name="hotel_name")
	private String hotelName;

	@Column(name="land_no")
	private String landNo;

	@Column(name="phone_no1")
	private String phoneNo1;

	@Column(name="phone_no2")
	private String phoneNo2;

	@Column(name="pincode")
	private String pincode;

	@Column(name="state")
	private String state;
	
	@Column(name="street")
	private String street;
	
	@Column(name="current_financial_year_id")
	private String currentFinancialYearId;

	//bi-directional many-to-one association to Role
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hotel")
	private List<Role> roles = new ArrayList<>();

	//bi-directional many-to-one association to User
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hotel")
	private List<Users> users = new ArrayList<>();
	
	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Room> rooms;

	public Hotel() {
	}

	public String getHotelId() {
		return hotelId;
	}

}