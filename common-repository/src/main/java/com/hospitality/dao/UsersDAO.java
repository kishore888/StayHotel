/** UserDAO.java  Dec 4,17
*/

package com.hospitality.dao;

import com.hospitality.core.Users;

/**
* @author  Kishore
*/

public interface UsersDAO extends GenericDAO<Users>{

	public Users retrieveByUserName(String userName) throws Exception;

}
