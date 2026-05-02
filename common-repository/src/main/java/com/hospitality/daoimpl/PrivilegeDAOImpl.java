/** PrivilegeDAOImpl.java  Dec 3,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Privilege;
import com.hospitality.core.Role;
import com.hospitality.dao.PrivilegeDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class PrivilegeDAOImpl extends GenericDAOImpl<Privilege> implements PrivilegeDAO{

	@Override
	public Privilege retrieveByPrivilegeId(String privilegeId) throws Exception {
		Privilege privilege = new Privilege();
		try{
			String queryString = "Select p from Privilege p join fetch p.module m where p.privilegeId=:privilegeId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("privilegeId", privilegeId);
			if(query.getResultList().size()>0) {
				privilege = (Privilege) query.getResultList().get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return privilege;
	}

}
