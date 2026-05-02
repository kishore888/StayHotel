package com.hospitality.payment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.Payment;
import com.hospitality.payment.bo.PaymentBO;

/**
* @author  #Kishore
*/

@RestController
@RequestMapping("/payment/")
public class PaymentController{
	
	@Autowired
	private PaymentBO paymentBO;
	
	@RequestMapping(value="showCreatePayment",method = RequestMethod.GET)
	public ModelAndView showCreatePayment(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePayment");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(Payment payment){
		try{
			paymentBO.create(payment);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePayment").addObject("payment", payment);
	}
	
	@RequestMapping(value="retrievePaymentList",method = RequestMethod.GET)
	public ModelAndView retrieveList(Payment payment){
		List<Payment> paymentList = new ArrayList<>();
		try{
			paymentList = paymentBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("paymentList").addObject("paymentList", paymentList);
	}
	
}
