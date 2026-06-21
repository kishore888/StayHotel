package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

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
@Data
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

}