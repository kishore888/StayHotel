/** ElementStyleDAOImpl.java  Jan 7,18
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.ElementStyle;
import com.hospitality.dao.ElementStyleDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class ElementStyleDAOImpl extends GenericDAOImpl<ElementStyle> implements ElementStyleDAO{

}
