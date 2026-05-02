package com.hospitality.daoimpl;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.dao.GenericDAO;
import com.hospitality.dto.DataTable;
import com.hospitality.dto.DataTableColumnDTO;
import com.hospitality.dto.DataTableDTO;

@Component
@Transactional
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(GenericDAOImpl.class);
	
	private Class<T> type;
	
//	@PersistenceContext(unitName="PERSISTENCE_UNIT")
//	public EntityManager entityManager;
	
	@PersistenceContext
	public EntityManager entityManager;
	
//	@PersistenceUnit
//    public EntityManagerFactory emf;
	
	public Session session;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(){
		ParameterizedType pt = (ParameterizedType) getClass().getGenericSuperclass();
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws Exception{
		final StringBuilder sb = new StringBuilder("SELECT o FROM ");
		sb.append(type.getSimpleName()).append(" o ");
		return entityManager.createQuery(sb.toString()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String pName, String pVal)throws Exception{
		final StringBuilder sb = new StringBuilder("SELECT o FROM ");
		sb.append(type.getSimpleName()).append(" o ");
		sb.append(" WHERE o."+pName+" = "+pVal);
		return entityManager.createQuery(sb.toString()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String pName, String pVal, String pJoin)throws Exception{
		final StringBuilder sb = new StringBuilder("SELECT o FROM ");
		sb.append(type.getSimpleName()).append(" o ");
		sb.append(" "+pJoin+" ");
		sb.append(" WHERE o."+pName+" = "+pVal);
		return entityManager.createQuery(sb.toString()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProperty(String pName, String pVal, String pJoin, int maxResults)throws Exception{
		final StringBuilder sb = new StringBuilder("SELECT o FROM ");
		sb.append(type.getSimpleName()).append(" o ");
		sb.append(" "+pJoin+" ");
		sb.append(" WHERE o."+pName+" = "+pVal);
		return entityManager.createQuery(sb.toString()).setMaxResults(maxResults).getResultList();
	}
	
	@Override
	public List<T> retrieveList()throws Exception{
		return this.findAll();
	}
	
	@Override
	public T findById(final String id)throws Exception{
		return entityManager.find(type, id);
	}
	
	@Override
	public T findByIdProxy(final String id)throws Exception{
		T t = (T)entityManager.getReference(type, id);
		return t;
	}
	
	@Override
	public T retrieveById(String id)throws Exception{
		return this.findById(id);
	}
	
	@Override
	public void saveAndCommit(final T entity)throws Exception{
		entityManager.persist(entity);
	}
	
	@Override
	public void save(final T entity)throws Exception{
		this.saveAndCommit(entity);
	}
	
	@Override
	public void deleteAndCommit(final Object id)throws Exception{
		entityManager.remove(id);
	}
	
	@Override
	public void delete(final Object id)throws Exception{
		this.deleteAndCommit(id);
	}
	
	@Override
	public void updateAndCommit(final T entity)throws Exception{
		entityManager.merge(entity);
	}
	
	@Override
	public void update(final T entity)throws Exception{
		this.updateAndCommit(entity);
	}
	
	@Override
	public void create(final T entity)throws Exception{
		this.save(entity);
	}
	
	public Map<String, Object> retrieveServerSideDataTable(DataTableDTO dataTableDTO, Set<String> otherJoins, String otherFilters, String groupBy) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		StringBuilder queryBuilder = new StringBuilder();
		try {
			groupBy = groupBy == null ? "" : groupBy;
			
			queryBuilder.append("From "+type.getSimpleName()+" o ");
			Set<String> joinEntities = dataTableDTO.getColumns().stream().filter(column->column.getData().contains("."))
										.map(column->column.getData().substring(0,  column.getData().lastIndexOf("."))).collect(Collectors.toSet());
			Boolean checkJoins = otherJoins == null ? null : joinEntities.addAll(otherJoins);
			Set<String> allJoinEntities = new TreeSet<>();
			for(String joinEntity : joinEntities) {
				build(joinEntity, allJoinEntities);
			}
			
			allJoinEntities.forEach(entity->queryBuilder.append(" join fetch o.").append(entity).append(""));
			
			Query q;
			StringBuilder conditions = new StringBuilder();
			Integer i=0;
			
			if(StringUtils.isNotBlank(otherFilters)) {
				conditions.append(" where "+otherFilters);
				i++;
			}
			
			q = entityManager.createQuery("select count(o."+dataTableDTO.getIdProp()+") "+queryBuilder.toString().replaceAll("fetch", "")+conditions+groupBy);
			
			resultMap.put("recordsTotal", q.getResultList());
			
			for(DataTableColumnDTO column : dataTableDTO.getColumns()) {
				if(StringUtils.isNotBlank(column.getSearch().getValue())) {
					if(i!=0) {
						conditions.append(" AND ");
						conditions.append(" o."+column.getData()+" LIKE "+" '%"+column.getSearch().getValue()+"%'");
					}else {
						conditions.append(" where o."+column.getData()+" LIKE "+"'%"+column.getSearch().getValue()+"%'");
					}
					i++;
				}
			}
			
			queryBuilder.append(conditions);
			queryBuilder.append(groupBy);
			
			Integer orderColNum = dataTableDTO.getOrder().get(0).getColumn();
			String orderDir = dataTableDTO.getOrder().get(0).getDir();
			String orderColName = dataTableDTO.getColumns().get(orderColNum).getData();
			
			if(dataTableDTO.getColumns().get(orderColNum).getOrderable()) {
				queryBuilder.append(" order by o.").append(orderColName).append(" "+orderDir);
			}
			
			q = entityManager.createQuery("select count(o."+dataTableDTO.getIdProp()+") "+queryBuilder.toString().replaceAll("fetch", "")+conditions+groupBy);
			resultMap.put("recordsFiltered", q.getResultList());
			
			q = entityManager.createQuery(queryBuilder.toString()).setFirstResult(dataTableDTO.getStart()).setMaxResults(dataTableDTO.getLength());
			
			resultMap.put("data", q.getResultList());
			resultMap.put("draw", dataTableDTO.getDraw());
		}catch(Exception e) {
			
		}
		return resultMap;
	}
	
	public static void build(String parts, Set<String> result) {
		String part = parts.substring(0,  parts.lastIndexOf(".") ==-1 ? parts.length() : parts.lastIndexOf("."));
		if(part.equals(parts)) {
			result.add(parts);
			return;
		}else {
			result.add(parts);
			build(part, result);
		}
	}
}
