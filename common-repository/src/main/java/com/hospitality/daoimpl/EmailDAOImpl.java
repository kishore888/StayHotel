/** EmailDAOImpl.java  Dec 31,17
*/

package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Email;
import com.hospitality.core.Hotel;
import com.hospitality.dao.EmailDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class EmailDAOImpl extends GenericDAOImpl<Email> implements EmailDAO{

	@Override
	public List<Email> retrieveEmailListByEmailId(String emailId) throws Exception {
		List<Email> emailList = new ArrayList<>();
		try {
			String queryString = "select e from Email e where e.to=:emailId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("emailId", emailId);
			emailList = query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emailList;
	}

}
