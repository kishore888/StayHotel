/** PrivilegeDAO.java  Dec 3,17
*/

package com.hospitality.dao;

import com.hospitality.core.Privilege;

/**
* @author  Kishore
*/

public interface PrivilegeDAO extends GenericDAO<Privilege>{

	Privilege retrieveByPrivilegeId(String privilegeId) throws Exception;

}
