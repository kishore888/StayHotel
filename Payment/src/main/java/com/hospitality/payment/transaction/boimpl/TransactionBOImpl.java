/** TransactionBOImpl.java  Nov 10,19
*/

package com.hospitality.payment.transaction.boimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.common.util.Constants;
import com.hospitality.core.Customer;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Payment;
import com.hospitality.core.PaymentAccount;
import com.hospitality.core.PaymentDetails;
import com.hospitality.core.Reservation;
import com.hospitality.core.Transaction;
import com.hospitality.core.TransactionDetails;
import com.hospitality.dao.PaymentAccountDAO;
import com.hospitality.dao.PaymentDAO;
import com.hospitality.dao.PaymentDetailsDAO;
import com.hospitality.dao.TransactionDAO;
import com.hospitality.dao.TransactionDetailsDAO;
import com.hospitality.payment.transaction.bo.TransactionBO;
import com.hospitality.util.PrimaryKeyListener;

/**
* @author  Kishore
*/

@Service("TransactionBO")
@Scope(value="prototype")
public class TransactionBOImpl implements TransactionBO{

	@Autowired
	private TransactionDAO transactionDAO;
	
	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private PaymentDetailsDAO paymentDetailsDAO;
	
	@Autowired
	private PaymentAccountDAO paymentAccountDAO;
	
//	@Autowired
//	private HotelBO hotelBO;
	
	@Autowired
	private TransactionDetailsDAO transactionDetailsDAO;
	
//	@Autowired
//	private ReservationBO reservationBO;
	
	@Override
	public void create(Transaction transaction) throws Exception{
		try{
			if(StringUtils.isNotBlank(transaction.getTransactionId())){
				transactionDAO.update(transaction);
			}else{
				transactionDAO.create(transaction);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Transaction> retrieveList() throws Exception{
		List<Transaction> transactionList = null;
		try{
			transactionList = transactionDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return transactionList;
	}

	@Override
	public String createTransaction(Customer customer, Hotel hotel) throws Exception {
		PaymentAccount paymentAccount = null;
		String clientTransactionNo = "";
		Double totalAmount = 0.0;
		try{
			totalAmount = customer.getReservationList().stream().collect(Collectors.summingDouble(r->r.getAmount()));
			
			paymentAccount = paymentAccountDAO.retrieveById(customer.getPaymentAccountId());
			
			Transaction transaction = new Transaction();
			clientTransactionNo = PrimaryKeyListener.smartPkey();
			transaction.setClientTransactionNo(clientTransactionNo);
			transaction.setAmount(totalAmount.floatValue());
//			transaction.setUdf1(udf1);
//			transaction.setUdf2(udf2);
			transaction.setPhoneNo(customer.getPhoneNo1());
			transaction.setEmailId(customer.getEmailId());
			transaction.setCustomer(customer);
			transaction.setPaymentAccount(paymentAccount);
			transactionDAO.create(transaction);
			
			for(Reservation reservation : customer.getReservationList()) {
				TransactionDetails transactionDetails = new TransactionDetails();
				transactionDetails.setAmount(reservation.getAmount());
				transactionDetails.setReservation(reservation);
				transactionDetails.setTransaction(transaction);
				transactionDetailsDAO.save(transactionDetails);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return clientTransactionNo;
	}

	@Override
	public Transaction retrieveByClientTransactionNo(String clientTransactionNo) throws Exception {
		Transaction transaction = null;
		try{
			transaction = transactionDAO.retrieveByClientTransactionNo(clientTransactionNo);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return transaction;
	}

	@Override
	public void payUSuccess(String clientTransactionNo, Hotel hotel) throws Exception {
		String billNo = "";
		PaymentAccount paymentAccount = null;
		Transaction transaction = null;
		try {
			transaction = transactionDAO.retrieveByClientTransactionNo(clientTransactionNo);
			
			paymentAccount = paymentAccountDAO.retrieveById(transaction.getPaymentAccount().getPaymentAccountId());
			//TODO: will add Hotel module and enable this line
//			billNo = hotelBO.generateBillNo(hotel, paymentAccount);
			
			PaymentDetails paymentDetails = new PaymentDetails();
			paymentDetails.setTotalAmount(transaction.getAmount());
			paymentDetails.setTypeOfPayment(Constants.ONLINE);
			paymentDetails.setBillNo(billNo);
			paymentDetailsDAO.save(paymentDetails);
			
			paymentAccount.setBillCount(paymentAccount.getBillCount()+1);
			paymentAccountDAO.update(paymentAccount);
			
			for(TransactionDetails transactionDetails : transaction.getTransactionDetailsList()) {
				Payment payment = new Payment();
				payment.setAmount(transactionDetails.getAmount());
				payment.setPaymentDetails(paymentDetails);
				payment.setReservation(transactionDetails.getReservation());
				paymentDAO.save(payment);
			}
			
			transaction.setPaymentDetails(paymentDetails);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

}
