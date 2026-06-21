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
 * The persistent class for the payment_account database table.
 * 
 */
@Entity
@Table(name="payment_account")
//@NamedQuery(name="PaymentAccount.findAll", query="SELECT p FROM PaymentAccount p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@JsonInclude(Include.NON_NULL)
@Data
public class PaymentAccount extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_account_id")
	private String paymentAccountId;

	private String name;
	
	private String code;
	
	@Column(name="bank_name")
	private String bankName;

	@Column(name="bill_count")
	private Integer billCount;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_payment_gateway_id")
	private HotelPaymentGateway hotelPaymentGateway;

	public PaymentAccount() {
	}

}