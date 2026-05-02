package com.hospitality.room.booking.bo;

import java.util.List;

import com.hospitality.core.HotelPlanMaster;

public interface HotelPlanMasterBO {

	public void create(HotelPlanMaster hotelPlanMaster);

	public List<HotelPlanMaster> retrieveListByYear();

}
