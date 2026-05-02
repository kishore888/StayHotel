package com.hospitality.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hospitality.dto.DataTableDTO;

public interface GenericDAO<T> {

	public List<T> findAll() throws Exception;
	public List<T> findByProperty(String pName, String pVal)throws Exception;
	public List<T> findByProperty(String pName, String pVal, String pJoin)throws Exception;
	public List<T> findByProperty(String pName, String pVal, String pJoin, int maxResults)throws Exception;
	public List<T> retrieveList()throws Exception;
	public T findById(final String id)throws Exception;
	public T findByIdProxy(final String id)throws Exception;
	public T retrieveById(String id)throws Exception;
	public void saveAndCommit(final T entity)throws Exception;
	public void save(final T entity)throws Exception;
	public void deleteAndCommit(final Object id)throws Exception;
	public void delete(final Object id)throws Exception;
	public void updateAndCommit(final T entity)throws Exception;
	public void update(final T entity)throws Exception;
	public void create(final T entity)throws Exception;
	
	public Map<String, Object> retrieveServerSideDataTable(DataTableDTO dataTableDTO, Set<String> otherJoins, String otherFilters, String groupBy) throws Exception;
	
}
