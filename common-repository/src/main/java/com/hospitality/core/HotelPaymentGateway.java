package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the hotel_payment_gateway database table.
 * 
 */
@Entity
@Table(name="hotel_payment_gateway")
//@NamedQuery(name="HotelPaymentGateway.findAll", query="SELECT h FROM HotelPaymentGateway h")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonInclude(Include.NON_NULL)
@Data
public class HotelPaymentGateway extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hotel_payment_gateway_id")
	private String hotelPaymentGatewayId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	@Column(name="merchant_id")
	private String merchantId;

	@Column(name="merchant_key")
	private String merchantKey;

	@Column(name="salt")
	private String salt;
	
	@Column(name="is_active")
	private Boolean isActive = false;

	//bi-directional many-to-one association to PaymentGateway
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_gateway_id")
	private PaymentGateway paymentGateway;

	public HotelPaymentGateway() {
	}

}