/** DepartmentDAOImpl.java  Oct 31,17
*/

package com.hospitality.daoimpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.Department;
import com.hospitality.dao.DepartmentDAO;


/**
* @author  Kishore
*/

@Repository
@Transactional
public class DepartmentDAOImpl extends GenericDAOImpl<Department> implements DepartmentDAO{

}
