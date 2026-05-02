package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.hospitality.util.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
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

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Float getAmount() {
		return this.amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public String getClientTransactionNo() {
		return this.clientTransactionNo;
	}

	public void setClientTransactionNo(String clientTransactionNo) {
		this.clientTransactionNo = clientTransactionNo;
	}

	public String getUdf1() {
		return this.udf1;
	}

	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}

	public String getUdf2() {
		return this.udf2;
	}

	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}

	public String getUdf3() {
		return this.udf3;
	}

	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}

	public String getUdf4() {
		return this.udf4;
	}

	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}

	public String getUdf5() {
		return this.udf5;
	}

	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo1) {
		this.phoneNo = phoneNo1;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<TransactionDetails> getTransactionDetailsList() {
		return transactionDetailsList;
	}

	public PaymentAccount getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(PaymentAccount paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public void setTransactionDetailsList(List<TransactionDetails> transactionDetailsList) {
		this.transactionDetailsList = transactionDetailsList;
	}

}