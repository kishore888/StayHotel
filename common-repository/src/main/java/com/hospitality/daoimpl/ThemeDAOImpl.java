/** ThemeDAOImpl.java  Jan 7,18
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Theme;
import com.hospitality.dao.ThemeDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class ThemeDAOImpl extends GenericDAOImpl<Theme> implements ThemeDAO{

	@Override
	public Theme retrieveByThemeId(String themeId) throws Exception {
		Theme theme = null;
		try {
			String queryString = "select t from Theme t left join fetch t.elementStyles es where t.themeId=:themeId";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("themeId", themeId);
			if(query.getResultList().size() > 0) {
				theme = (Theme) query.getResultList().get(0);
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return theme;
	}

}
