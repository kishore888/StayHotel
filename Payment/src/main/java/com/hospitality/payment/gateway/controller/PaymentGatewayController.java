/** PaymentGatewayController.java  Jun 6,19
*/


package com.hospitality.payment.gateway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.PaymentGateway;
import com.hospitality.payment.gateway.bo.PaymentGatewayBO;

/**
* @author  #Kishore
*/

@RestController
@RequestMapping("/payment/paymentGateway/")
public class PaymentGatewayController{
	
	@Autowired
	private PaymentGatewayBO paymentGatewayBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreatePaymentGateway(){
		try{
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("PaymentGateway");
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(PaymentGateway paymentGateway){
		try{
			paymentGatewayBO.create(paymentGateway);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePaymentGateway").addObject("paymentGateway", paymentGateway);
	}
	
	@RequestMapping(value="retrievePaymentGatewayList",method = RequestMethod.GET)
	public ModelAndView retrieveList(PaymentGateway paymentGateway){
		List<PaymentGateway> paymentGatewayList = null;
		try{
			paymentGatewayList = paymentGatewayBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("paymentGatewayList").addObject("paymentGatewayList", paymentGatewayList);
	}
	
}
