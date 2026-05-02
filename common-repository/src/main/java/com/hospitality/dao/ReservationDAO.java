/** ReservationDAO.java  Nov 12,19
*/

package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Reservation;

/**
* @author  #Kishore
*/

public interface ReservationDAO extends GenericDAO<Reservation>{

	public Reservation retrieveByReservationId(String reservationId) throws Exception;
	public List<Reservation> retrieveListByIds(List<String> reservationIdList) throws Exception;

}
