/** HotelDAOImpl.java  Dec 3,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Hotel;
import com.hospitality.dao.HotelDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class HotelDAOImpl extends GenericDAOImpl<Hotel> implements HotelDAO{

	@Override
	public Hotel retrieveHotelByUserName(String userName) throws Exception {
		Hotel hotel = new Hotel();
		try {
			String queryString = "select h from Hotel h join fetch h.users u where u.userName=:userName";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("userName", userName);
			if(query.getResultList().size()>0) {
				hotel = (Hotel) query.getResultList().get(0);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return hotel;
	}

}
