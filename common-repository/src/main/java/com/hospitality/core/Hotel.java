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
		return this.hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getHotelName() {
		return this.hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getLandNo() {
		return this.landNo;
	}

	public void setLandNo(String landNo) {
		this.landNo = landNo;
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

	public void setPhoneNo2(String phoneNo2) {
		this.phoneNo2 = phoneNo2;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
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

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Role addRole(Role role) {
		getRoles().add(role);
		role.setHotel(this);

		return role;
	}

	public Role removeRole(Role role) {
		getRoles().remove(role);
		role.setHotel(null);

		return role;
	}

	public String getCurrentFinancialYearId() {
		return currentFinancialYearId;
	}

	public void setCurrentFinancialYearId(String currentFinancialYearId) {
		this.currentFinancialYearId = currentFinancialYearId;
	}

	public List<Users> getUsers() {
		return this.users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public Users addUser(Users user) {
		getUsers().add(user);
		user.setHotel(this);

		return user;
	}

	public Users removeUser(Users user) {
		getUsers().remove(user);
		user.setHotel(null);

		return user;
	}
	
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

}