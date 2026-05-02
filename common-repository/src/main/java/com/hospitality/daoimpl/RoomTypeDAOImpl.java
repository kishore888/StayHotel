package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.RoomType;
import com.hospitality.dao.RoomTypeDAO;

@Repository
@Transactional
public class RoomTypeDAOImpl extends GenericDAOImpl<RoomType> implements RoomTypeDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<RoomType> retrieveListByYear() {
		List<RoomType> roomTypeList = new ArrayList<>();
		try{
			String queryString = "Select rt from RoomType rt";
			Query query = entityManager.createQuery(queryString);
			roomTypeList = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return roomTypeList;
	}
 
// public void create(){
//	 try{
//		 String queryString = "Insert into RoomType ";
//	 }catch(Exception e){
//		 e.printStackTrace();
//	 }
// }
 
 

}
