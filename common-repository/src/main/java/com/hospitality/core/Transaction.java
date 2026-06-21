package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
@Data
public class Transaction extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transaction_id")
	private String transactionId;

	@Column(name="amount")
	private Float amount = 0.0f;

	@Column(name="client_transaction_no")
	private String clientTransactionNo;

	@Column(name="udf1")
	private String udf1;

	@Column(name="udf2")
	private String udf2;

	@Column(name="udf3")
	private String udf3;

	@Column(name="udf4")
	private String udf4;

	@Column(name="udf5")
	private String udf5;
	
	@Column(name="phone_no")
	private String phoneNo;
	
	@Column(name="email_id")
	private String emailId;
	
	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;
	
	@OneToOne
	@JoinColumn(name="payment_details_id")
	private PaymentDetails paymentDetails;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_account_id")
	private PaymentAccount paymentAccount;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
    private List<TransactionDetails> transactionDetailsList = new ArrayList<>(0);

	public Transaction() {
	}

}