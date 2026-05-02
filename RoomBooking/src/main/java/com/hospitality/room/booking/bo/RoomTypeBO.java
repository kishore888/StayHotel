package com.hospitality.room.booking.bo;

import java.util.List;

import com.hospitality.core.RoomType;

public interface RoomTypeBO {

	public void create(RoomType roomType);

	public List<RoomType> retrieveListByYear();
}
