/** RoleDAOImpl.java  Dec 3,17
*/

package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Role;
import com.hospitality.core.Room;
import com.hospitality.dao.RoleDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class RoleDAOImpl extends GenericDAOImpl<Role> implements RoleDAO{

	@Override
	public Role retrieveByRoleId(Role role) throws Exception {
		try{
			String queryString = "Select r from Role r join fetch r.hotel h where r.roleId=:roleId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("roleId", role.getRoleId());
			if(query.getResultList().size()>0) {
				role = (Role) query.getResultList().get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return role;
	}

}
