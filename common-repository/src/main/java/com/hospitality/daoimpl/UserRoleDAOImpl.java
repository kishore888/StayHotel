/** UserRoleDAOImpl.java  Dec 4,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.UserRole;
import com.hospitality.dao.UserRoleDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class UserRoleDAOImpl extends GenericDAOImpl<UserRole> implements UserRoleDAO{

}
