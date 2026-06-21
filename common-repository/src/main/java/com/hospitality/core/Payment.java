package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;


/**
 * The persistent class for the payment database table.
 * 
 */
@Entity
//@NamedQuery(name="Payment.findAll", query="SELECT p FROM Payment p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
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

}