/** HotelDAO.java  Dec 3,17
*/

package com.hospitality.dao;

import com.hospitality.core.Hotel;

/**
* @author  Kishore
*/

public interface HotelDAO extends GenericDAO<Hotel>{

	Hotel retrieveHotelByUserName(String name) throws Exception;

}
