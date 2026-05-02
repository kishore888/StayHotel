package com.hospitality.payment.transaction.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.Hotel;
import com.hospitality.core.Transaction;
import com.hospitality.payment.transaction.bo.TransactionBO;

/**
* @author  Kishore
*/

@RestController
@RequestMapping("/payment/transaction/")
public class TransactionController {
	
	@Autowired
	private TransactionBO transactionBO;
	
	@RequestMapping(value="showCreateTransaction",method = RequestMethod.GET)
	public ModelAndView showCreateTransaction(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateTransaction");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Transaction Transaction){
		try{
			transactionBO.create(Transaction);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreateTransaction").addObject("Transaction", Transaction);
	}
	
	@RequestMapping(value="retrieveTransactionList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Transaction Transaction){
		List<Transaction> TransactionList = null;
		try{
			TransactionList = transactionBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("TransactionList").addObject("TransactionList", TransactionList);
	}
	
	@RequestMapping(value="payUSuccess",method = RequestMethod.POST)
	public ModelAndView payUSuccess(String clientTransactionNo, HttpSession session){
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			transactionBO.payUSuccess(clientTransactionNo, hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/room/retrieveRoomList");
	}
	
	@RequestMapping(value="payUFailure",method = RequestMethod.POST)
	public ModelAndView payUFailure(String clientTransactionNo, HttpSession session){
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			transactionBO.payUSuccess(clientTransactionNo, hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("PayUErr", "txnid", clientTransactionNo);
	}
	
}