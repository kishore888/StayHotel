package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.Hotel;
import com.hospitality.core.Room;

public interface RoomDAO extends GenericDAO<Room>{

	public List<Room> retrieveRoomList(Hotel hotel) throws Exception;
	public Room retrieveByRoomId(String roomId) throws Exception;
	public List<Room> retrieveListByIds(List<String> roomIdList) throws Exception;
	public Hotel retrieveHotelbyId(String hotelId) throws Exception;

}
