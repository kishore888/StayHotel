package com.hospitality.room.booking.bo;

import java.util.List;
import java.util.Map;

import com.hospitality.core.Hotel;
import com.hospitality.core.Room;
import com.hospitality.dto.DataTableDTO;

public interface RoomBO {

	public void create(Room room);
	public List<Room> retrieveRoomList(Hotel hotel) throws Exception;
	public Map<String, Object> retrieveRoomsServersideDatatable(DataTableDTO dataTable, Hotel hotel) throws Exception;
	public Room retrieveById(String roomId) throws Exception;
	public Room retrieveByRoomId(String roomId) throws Exception;
	public List<Room> retrieveListByIds(List<String> roomIdList) throws Exception;
	public Hotel retrieveHotelbyId(String hotelId) throws Exception;

}
