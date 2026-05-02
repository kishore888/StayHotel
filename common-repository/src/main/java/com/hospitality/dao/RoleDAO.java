/** RoleDAO.java  Dec 3,17
*/

package com.hospitality.dao;

import com.hospitality.core.Role;

/**
* @author  Kishore
*/

public interface RoleDAO extends GenericDAO<Role>{

	Role retrieveByRoleId(Role role) throws Exception;

}
