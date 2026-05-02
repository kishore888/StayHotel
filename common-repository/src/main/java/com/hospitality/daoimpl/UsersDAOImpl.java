/** UserDAOImpl.java  Dec 4,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Users;
import com.hospitality.dao.UsersDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class UsersDAOImpl extends GenericDAOImpl<Users> implements UsersDAO{

	@Override
	public Users retrieveByUserName(String userName) throws Exception {
		Users user = null;
		try {
			String queryString = "select u from Users u where u.userName=:userName";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("userName", userName);
			if(query.getResultList().size() > 0) {
				user = (Users) query.getResultList().get(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return user;
	}

}
