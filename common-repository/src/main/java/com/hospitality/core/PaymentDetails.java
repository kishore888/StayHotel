package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the payment_details database table.
 * 
 */
@Entity
@Table(name="payment_details")
//@NamedQuery(name="PaymentDetail.findAll", query="SELECT p FROM PaymentDetail p")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class PaymentDetails extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="payment_details_id")
	private String paymentDetailsId;

	@Column(name="bill_no")
	private String billNo;
	
	@Column(name="total_amount")
	private Float totalAmount = 0.0f;

	@Column(name="type_of_payment")
	private String typeOfPayment;
	
	@Column(name="cheque_no")
	private String chequeNo;
	
	private String bank;

	@Column(name="bank_branch")
	private String bankBranch;

	private String dd;

	@Column(name="pos_no")
	private String posNo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="paymentDetails")
	private List<Payment> payments = new ArrayList<Payment>();

	public PaymentDetails() {
	}

	public String getPaymentDetailsId() {
		return this.paymentDetailsId;
	}

	public void setPaymentDetailsId(String paymentDetailsId) {
		this.paymentDetailsId = paymentDetailsId;
	}

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankBranch() {
		return this.bankBranch;
	}

	public void setBankBranch(String bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getChequeNo() {
		return this.chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getDd() {
		return this.dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public String getPosNo() {
		return this.posNo;
	}

	public void setPosNo(String posNo) {
		this.posNo = posNo;
	}

	public Float getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTypeOfPayment() {
		return this.typeOfPayment;
	}

	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setPaymentDetails(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setPaymentDetails(null);

		return payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}