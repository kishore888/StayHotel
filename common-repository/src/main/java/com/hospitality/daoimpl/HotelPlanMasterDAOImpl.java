package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.HotelPlanMaster;
import com.hospitality.dao.HotelPlanMasterDAO;

@Repository
@Transactional
public class HotelPlanMasterDAOImpl extends GenericDAOImpl<HotelPlanMaster> implements HotelPlanMasterDAO{

	@Override
	public List<HotelPlanMaster> retrieveListByYear() {
		List<HotelPlanMaster> hotelPlanMasterList = new ArrayList<>();
		try{
			String queryString = "Select hpm from HotelPlanMaster hpm";
			Query query = entityManager.createQuery(queryString);
			hotelPlanMasterList = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelPlanMasterList;
	}

}
