/** ModuleDAOImpl.java  Dec 3,17
*/

package com.hospitality.daoimpl;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Module;
import com.hospitality.dao.ModuleDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class ModuleDAOImpl extends GenericDAOImpl<Module> implements ModuleDAO{

}
