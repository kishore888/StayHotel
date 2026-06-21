package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the payment_gateway database table.
 * 
 */
@Entity
@Table(name="payment_gateway")
//@NamedQuery(name="PaymentGateway.findAll", query="SELECT p FROM PaymentGateway p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class PaymentGateway extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_gateway_id")
	private String paymentGatewayId;

	@Column(name="base_url")
	private String baseUrl;

	@Column(name="is_active")
	private Boolean isActive = false;

	@Column(name="merchant_id")
	private String merchantId;

	@Column(name="merchant_key")
	private String merchantKey;

	@Column(name="payment_gateway_name")
	private String paymentGatewayName;

	@Column(name="salt")
	private String salt;

	//bi-directional many-to-one association to HotelPaymentGateway
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="paymentGateway")
	private List<HotelPaymentGateway> hotelPaymentGateways = new ArrayList<>();

	public PaymentGateway() {
	}

}