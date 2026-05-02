package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

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

	public String getHotelPaymentGatewayId() {
		return hotelPaymentGatewayId;
	}

	public void setHotelPaymentGatewayId(String hotelPaymentGatewayId) {
		this.hotelPaymentGatewayId = hotelPaymentGatewayId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	public PaymentGateway getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(PaymentGateway paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

}