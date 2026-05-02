/** RolePrivilegeDAOImpl.java  Dec 3,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.RolePrivilege;
import com.hospitality.dao.RolePrivilegeDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class RolePrivilegeDAOImpl extends GenericDAOImpl<RolePrivilege> implements RolePrivilegeDAO{

}
