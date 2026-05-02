package com.hospitality.room.booking.boimpl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.hospitality.core.RoomType;
import com.hospitality.dao.RoomTypeDAO;
import com.hospitality.room.booking.bo.RoomTypeBO;

@Service("RoomTypeBO")
@Scope(value="prototype")
public class RoomTypeBOImpl implements RoomTypeBO{

	@Autowired
	private RoomTypeDAO roomTypeDAO;
	
	@Override
	public void create(RoomType roomType){
		try{
			if(StringUtils.isNotBlank(roomType.getRoomTypeId())){
				roomTypeDAO.update(roomType);
			}else{
				roomTypeDAO.create(roomType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public List<RoomType> retrieveListByYear() {
		List<RoomType> roomTypeList = null;
		try{
			roomTypeList = roomTypeDAO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
		}
		return roomTypeList;
	}
}
