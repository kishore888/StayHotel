/** PaymentAccountController.java  Dec 8,19
*/


package com.hospitality.payment.account.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.PaymentAccount;
import com.hospitality.payment.account.bo.PaymentAccountBO;
import com.hospitality.payment.gateway.bo.HotelPaymentGatewayBO;

/**
* @author  #Kishore
*/

@RestController
@RequestMapping("/payment/paymentAccount/")
public class PaymentAccountController {
	
	@Autowired
	private PaymentAccountBO paymentAccountBO;
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreatePaymentAccount(String paymentAccountId, HttpSession session){
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Hotel hotel = null;
		PaymentAccount paymentAccount = null;
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			if(StringUtils.isNotBlank(paymentAccountId)) {
				paymentAccount = paymentAccountBO.retrieveById(paymentAccountId);
			}
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("CreatePaymentAccount", "hotelPaymentGatewayList", hotelPaymentGatewayList).addObject("paymentAccount", paymentAccount).addObject("paymentAccountList", paymentAccountList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(PaymentAccount paymentAccount){
		try{
			paymentAccountBO.create(paymentAccount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create?paymentAccountId="+paymentAccount.getPaymentAccountId());
	}
	
	@RequestMapping(value="delete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> delete(PaymentAccount paymentAccount){
		Map<String, Object> response = new HashMap<String, Object>();
		try{
			paymentAccountBO.delete(paymentAccount);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="retrieveList")
	public ResponseEntity<List<PaymentAccount>> retrieveList(Hotel hotel, HttpSession session){
		List<PaymentAccount> paymentAccountList = new ArrayList<>();
		try{
//			hotel = (Hotel)session.getAttribute("hotelObj");
			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(paymentAccountList);
	}
	
}
