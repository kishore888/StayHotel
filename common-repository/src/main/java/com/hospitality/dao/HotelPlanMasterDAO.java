package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.HotelPlanMaster;

public interface HotelPlanMasterDAO extends GenericDAO<HotelPlanMaster>{

	public List<HotelPlanMaster> retrieveListByYear();

}
