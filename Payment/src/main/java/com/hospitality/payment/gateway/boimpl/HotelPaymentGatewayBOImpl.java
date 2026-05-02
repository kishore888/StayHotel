package com.hospitality.payment.gateway.boimpl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Transaction;
import com.hospitality.dao.HotelPaymentGatewayDAO;
import com.hospitality.payment.gateway.bo.HotelPaymentGatewayBO;

/**
* @author  #Kishore
*/

@Service("HotelPaymentGatewayBO")
@Scope(value="prototype")
public class HotelPaymentGatewayBOImpl implements HotelPaymentGatewayBO{

	@Autowired
	private HotelPaymentGatewayDAO hotelPaymentGatewayDAO;
	
	@Override
	public void create(HotelPaymentGateway hotelPaymentGateway) throws Exception{
		try{
			if(StringUtils.isNotBlank(hotelPaymentGateway.getHotelPaymentGatewayId())){
				hotelPaymentGatewayDAO.update(hotelPaymentGateway);
			}else{
				hotelPaymentGatewayDAO.create(hotelPaymentGateway);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<HotelPaymentGateway> retrieveList() throws Exception{
		List<HotelPaymentGateway> hotelPaymentGatewayList = null;
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelPaymentGatewayList;
	}

	@Override
	public HotelPaymentGateway retrieveById(String hotelPaymentGatewayId) throws Exception {
		HotelPaymentGateway hotelPaymentGateway = null;
		try{
			hotelPaymentGateway = hotelPaymentGatewayDAO.retrieveById(hotelPaymentGatewayId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGateway;
	}

	@Override
	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGatewayList;
	}

	@Override
	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId) throws Exception {
		HotelPaymentGateway hotelPaymentGateway = null;
		try{
			hotelPaymentGateway = hotelPaymentGatewayDAO.retrieveByHotelPaymentGatewayId(hotelPaymentGatewayId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGateway;
	}

	@Override
	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		try{
			hotelPaymentGatewayList = hotelPaymentGatewayDAO.retrieveActiveGatewayListByHotel(hotel);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return hotelPaymentGatewayList;
	}

	@Override
	public String payU(Transaction transaction, String baseUrl) throws Exception {
		String payUhtml = "";
		Map<String, String> map = new HashMap<>();
		try{
			String key = "gtKFFx";
			String salt = "eCwWELxi";
			String txnid = transaction.getClientTransactionNo();
			String amount = transaction.getAmount().toString();
			String productinfo = "";
			productinfo = "SAU Admission 2014";
			String firstname = transaction.getCustomer().getFirstName();
			String lastname = transaction.getCustomer().getLastName();
			String email = transaction.getCustomer().getEmailId();
			String phone = transaction.getCustomer().getPhoneNo1();
//			String service_provider = "payu_paisa";
			
			String hashStr = key+"|"+txnid+"|"+amount+"|"+productinfo+"|"+firstname+"|"+email+"|||||||||||"+salt;
//			String[] checksumArr = hashStr.split("|");
			
			byte[] hashseq = hashStr.getBytes();
	        StringBuffer hexString = new StringBuffer();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.reset();
			md.update(hashseq);
            byte messageDigest[] = md.digest();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append("0");
                }
                hexString.append(hex);
            }
			
            map.put("firstname", firstname);
			map.put("lastname", lastname);
			map.put("surl", baseUrl+"/transaction/payUSuccess?clientTransactionNo="+txnid);
			map.put("phone", phone);
			map.put("key", key);
			map.put("hash", hexString.toString());
			map.put("curl", "");
			map.put("furl", baseUrl+"/transaction/payUFailure?clientTransactionNo="+txnid);
			map.put("txnid", txnid);
			map.put("productinfo", productinfo);
			map.put("amount", amount);
			map.put("email", email);
			
            payUhtml = "<html>\n" + 
			"<head>\n" + 
			"</head>\n" + 
			"<body>\n" + 
			"<form id=\"payUSubmit\" action='https://test.payu.in/_payment' method='post'>\n" ; 
			
			for (Map.Entry<String, String> entry : map.entrySet()) {
				payUhtml += "<input type=\"hidden\" name=\""+entry.getKey()+"\" value=\""+entry.getValue()+"\" />\n";
			}
			            
			payUhtml += "<input type= \"submit\" value=\"submit\">\n" + 
			"</form>\n" + 
			"</body></html>"+
			"<script>document.getElementById(\"payUSubmit\").submit();</script>";
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return payUhtml;
	}

}