package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
//@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Payment extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_id")
	private String paymentId;

	private Float amount = 0.0f;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="reservation_id")
	private Reservation reservation;

	//bi-directional many-to-one association to PaymentDetail
	@ManyToOne
	@JoinColumn(name="payment_details_id")
	private PaymentDetails paymentDetails;

	public Payment() {
	}

	public String getPaymentId() {
		return this.paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}


}