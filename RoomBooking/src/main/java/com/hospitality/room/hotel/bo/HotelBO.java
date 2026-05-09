package com.hospitality.room.hotel.bo;

import java.util.List;

import com.hospitality.core.Hotel;

public interface HotelBO {

	public List<Hotel> retrieveList() throws Exception;

	public Hotel retrieveById(String hotelId) throws Exception;

	public void create(Hotel hotel) throws Exception;

	public void update(Hotel hotel) throws Exception;

	public void delete(String hotelId) throws Exception;

}
