package com.hospitality.room.booking.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.HotelPlanMaster;
import com.hospitality.dao.HotelPlanMasterDAO;
import com.hospitality.room.booking.bo.HotelPlanMasterBO;

@Service("HotelPlanMasterBO")
@Scope(value="prototype")
public class HotelPlanMasterBOImpl implements HotelPlanMasterBO{

	@Autowired
	private HotelPlanMasterDAO hotelPlanMasterDAO;
	
	public void create(HotelPlanMaster hotelPlanMaster){
		try{
			if(StringUtils.isNotBlank(hotelPlanMaster.getHotelPlanMasterId())){
				hotelPlanMasterDAO.update(hotelPlanMaster);
			}else{
				hotelPlanMasterDAO.create(hotelPlanMaster);
			}
			throw new NullPointerException();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<HotelPlanMaster> retrieveListByYear() {
		List<HotelPlanMaster> hotelPlanMasterList = null;
		try{
			hotelPlanMasterList = hotelPlanMasterDAO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hotelPlanMasterList;
	}
}
