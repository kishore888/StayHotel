/** ThemeDAO.java  Jan 7,18
*/

package com.hospitality.dao;

import com.hospitality.core.Theme;

/**
* @author  Kishore
*/

public interface ThemeDAO extends GenericDAO<Theme>{

	public Theme retrieveByThemeId(String themeId)throws Exception;

}
