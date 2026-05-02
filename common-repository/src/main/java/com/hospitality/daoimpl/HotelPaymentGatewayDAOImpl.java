/** HotelPaymentGatewayDAOImpl.java  Jun 6,19
*/

package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

//import org.hibernate.mapping.Array;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.dao.HotelPaymentGatewayDAO;

//import javassist.bytecode.stackmap.BasicBlock.Catch;


/**
* @author  #Kishore
*/

@Repository
@Transactional
public class HotelPaymentGatewayDAOImpl extends GenericDAOImpl<HotelPaymentGateway> implements HotelPaymentGatewayDAO{

	@Override
	public List<HotelPaymentGateway> retrieveListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<HotelPaymentGateway>();
		try {
			String queryString = "select hpg from HotelPaymentGateway hpg Join hpg.hotel h join fetch hpg.paymentGateway where h.hotelId=:hotelId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelId", hotel.getHotelId());
			hotelPaymentGatewayList = query.getResultList();
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		return hotelPaymentGatewayList;
	}

	@Override
	public HotelPaymentGateway retrieveByHotelPaymentGatewayId(String hotelPaymentGatewayId) throws Exception {
		HotelPaymentGateway hotelPaymentGateway = null;
		try {
			String queryString = "select hpg from HotelPaymentGateway hpg join fetch hpg.paymentGateway where hpg.hotelPaymentGatewayId=:hotelPaymentGatewayId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelPaymentGatewayId", hotelPaymentGatewayId);
			if(query.getResultList().size() > 0) {
				hotelPaymentGateway = (HotelPaymentGateway) query.getSingleResult();
			}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		return hotelPaymentGateway;
	}

	@Override
	public List<HotelPaymentGateway> retrieveActiveGatewayListByHotel(Hotel hotel) throws Exception {
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<HotelPaymentGateway>();
		try {
			String queryString = "select hpg from HotelPaymentGateway hpg Join hpg.hotel h join fetch hpg.paymentGateway where h.hotelId=:hotelId and hpg.isActive='1'";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("hotelId", hotel.getHotelId());
			hotelPaymentGatewayList = query.getResultList();
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
		return hotelPaymentGatewayList;
	}

}
