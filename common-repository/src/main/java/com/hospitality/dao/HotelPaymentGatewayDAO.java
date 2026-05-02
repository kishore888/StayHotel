/** HotelPaymentGatewayDAO.java  Jun 6,19
*/

package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;

/**
* @author  #Kishore
*/

public interface HotelPaymentGatewayDAO extends GenericDAO<HotelPaymentGateway>{

	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception;

	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId)throws Exception;

	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel)throws Exception;

}
