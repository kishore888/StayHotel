package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
//@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Reservation extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="reservation_id")
	private String reservationId;
	
//	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
//	@JoinColumn(name="customer_id")
//	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm a")
	@Column(name="check_in")
	private Date checkIn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm a")
	@Column(name="check_out")
	private Date checkOut;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_account_id")
	private PaymentAccount paymentAccount;
	
	@Transient
	private Float amount = 0.0f;
	
	@Transient
	private Float totalAmount = 0.0f;

	@Transient
	private String paymentType;
	
	public Reservation() {
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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

	public PaymentAccount getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(PaymentAccount paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

}