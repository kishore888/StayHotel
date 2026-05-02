package com.hospitality.payment.gateway.bo;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Transaction;

/**
* @author  #Kishore
*/

public interface HotelPaymentGatewayBO {

	public void create(HotelPaymentGateway hotelPaymentGateway) throws Exception;
	public List<HotelPaymentGateway> retrieveList() throws Exception;
	public HotelPaymentGateway retrieveById(String hotelPaymentGatewayId) throws Exception;
	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception;
	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId) throws Exception;
	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel) throws Exception;
	public String payU(Transaction transaction, String baseUrl) throws Exception;

}