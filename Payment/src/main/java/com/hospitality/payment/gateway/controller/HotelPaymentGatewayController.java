/** HotelPaymentGatewayController.java  Jun 6,19
*/


package com.hospitality.payment.gateway.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.hospitality.core.Customer;
import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.PaymentGateway;
import com.hospitality.core.Transaction;
import com.hospitality.payment.gateway.bo.HotelPaymentGatewayBO;
import com.hospitality.payment.gateway.bo.PaymentGatewayBO;
import com.hospitality.payment.transaction.bo.TransactionBO;

/**
* @author  #Kishore
*/

@RestController
@RequestMapping("/payment/hotelPaymentGateway/")
public class HotelPaymentGatewayController {
	
	@Autowired
	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
	@Autowired
	private PaymentGatewayBO paymentGatewayBO;
	
	@Autowired
	private TransactionBO transactionBO;
	
	@RequestMapping(value="create",method = RequestMethod.GET)
	public ModelAndView showCreateHotelPaymentGateway(HotelPaymentGateway hotelPaymentGateway, HttpSession session){
		List<PaymentGateway> paymentGateways = new ArrayList<>();
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Hotel hotel = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			paymentGateways = paymentGatewayBO.retrieveList();
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveListByHotel(hotel);
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())) {
				hotelPaymentGateway = hotelPaymentGatewayBO.retrieveById(hotelPaymentGateway.getHotelPaymentGatewayId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("HotelPaymentGateway", "paymentGateways", paymentGateways).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
			
	@RequestMapping(value="create",method = RequestMethod.POST)
	public ModelAndView create(HotelPaymentGateway hotelPaymentGateway){
		try{
			hotelPaymentGatewayBO.create(hotelPaymentGateway);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:create");
	}
	
	@RequestMapping(value="retrieveHotelPaymentGatewayList",method = RequestMethod.GET)
	public ModelAndView retrieveList(HotelPaymentGateway hotelPaymentGateway){
		List<HotelPaymentGateway> hotelPaymentGatewayList = null;
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("hotelPaymentGatewayList").addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
	}
	
	@RequestMapping(value="retrieveById",method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> retrieveById(String hotelPaymentGatewayId){
		HotelPaymentGateway hotelPaymentGateway = null;
		Map<String, Object> response = new HashMap<String, Object>();
		try{
			hotelPaymentGateway = hotelPaymentGatewayBO.retrieveByHotelPaymentGatewayId(hotelPaymentGatewayId);
			response.put("hotelPaymentGateway", hotelPaymentGateway);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="pay",method = RequestMethod.GET)
	public ModelAndView pay(Customer customer, String hotelPaymentGatewayId, HttpSession session, Model model){
		Hotel hotel = null;
		ModelAndView modelAndView = null;
		String clientTransactionNo = "";
		HotelPaymentGateway hotelPaymentGateway = null;
		try{
			hotel = (Hotel)session.getAttribute("hotelObj");
			if(StringUtils.isNotBlank(hotelPaymentGatewayId)) {
				hotelPaymentGateway = hotelPaymentGatewayBO.retrieveByHotelPaymentGatewayId(hotelPaymentGatewayId);
			}
			
			clientTransactionNo = transactionBO.createTransaction(customer, hotel);
			if(hotelPaymentGateway.getPaymentGateway().getPaymentGatewayName().equalsIgnoreCase("payU")) {
				modelAndView = new ModelAndView("redirect:payU?clientTransactionNo="+clientTransactionNo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return modelAndView;
	}
	
	@RequestMapping(value="payU",method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String payU(String clientTransactionNo, HttpServletRequest request, HttpServletResponse response){
		String str = "";
		Transaction transaction = null;
		try{
			HttpRequest httpRequest = new ServletServerHttpRequest(request);
		    UriComponents uriComponents = UriComponentsBuilder.fromHttpRequest(httpRequest).build();

		    String scheme = uriComponents.getScheme();             // http / https
			String serverName = request.getServerName();		   // hostname.com
			int serverPort = request.getServerPort();				// 8080
			String contextPath = request.getContextPath();   		// /app
			String baseUrl = scheme+"://"+serverName+":"+serverPort+contextPath;
			transaction = transactionBO.retrieveByClientTransactionNo(clientTransactionNo);
			str = hotelPaymentGatewayBO.payU(transaction, baseUrl);
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
}
