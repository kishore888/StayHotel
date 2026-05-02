/** EmailDAO.java  Dec 31,17
*/

package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Email;

/**
* @author  Kishore
*/

public interface EmailDAO extends GenericDAO<Email>{

	public List<Email> retrieveEmailListByEmailId(String emailId) throws Exception;

}
