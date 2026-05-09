package com.hospitality.core;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * The persistent class for the room database table.
 * 
 */
@Entity
@Table(name="room")
//@NamedQuery(name="Room.findAll", query="SELECT r FROM Room r")
//@JsonIdentityInfo(generator = JSOGGenerator.class)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "roomId")
//@JsonInclude(Include.NON_NULL)
@Data
public class Room extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="room_id")
	private String roomId;

	@Column(name="room_number")
	private Integer roomNumber;

//	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_type_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private RoomType roomType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_plan_master_id")
//	@JsonBackReference
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private HotelPlanMaster hotelPlanMaster;

	@Column(name="room_charges")
	private Double roomCharges;
	
	@Column(name="max_no_of_adults")
	private Integer maxNoOfAdults;

	@Column(name="max_no_of_kids")
	private Integer maxNoOfKids;

	@Column(name="status")
	private String status;
	
//	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_account_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private PaymentAccount paymentAccount;
	
	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnoreProperties({"rooms", "hibernateLazyInitializer", "handler"})
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	public Room() {
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public HotelPlanMaster getHotelPlanMaster() {
		return hotelPlanMaster;
	}

	public void setHotelPlanMaster(HotelPlanMaster hotelPlanMaster) {
		this.hotelPlanMaster = hotelPlanMaster;
	}

	public Double getRoomCharges() {
		return roomCharges;
	}

	public void setRoomCharges(Double roomCharges) {
		this.roomCharges = roomCharges;
	}

	public Integer getMaxNoOfAdults() {
		return maxNoOfAdults;
	}

	public void setMaxNoOfAdults(Integer maxNoOfAdults) {
		this.maxNoOfAdults = maxNoOfAdults;
	}

	public Integer getMaxNoOfKids() {
		return maxNoOfKids;
	}

	public void setMaxNoOfKids(Integer maxNoOfKids) {
		this.maxNoOfKids = maxNoOfKids;
	}

	public String getStatus() {
		return status;
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

	public PaymentAccount getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(PaymentAccount paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

}