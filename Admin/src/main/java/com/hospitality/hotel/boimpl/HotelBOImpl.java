package com.hospitality.hotel.boimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospitality.core.Hotel;
import com.hospitality.dao.HotelDAO;
import com.hospitality.hotel.bo.HotelBO;

@Service
public class HotelBOImpl implements HotelBO {

	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public List<Hotel> retrieveList() throws Exception {
		List<Hotel> hotelList = new ArrayList<>();
		try {
			hotelList = hotelDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return hotelList;
	}

	@Override
	public Hotel retrieveById(String hotelId) throws Exception {
		Hotel hotel = new Hotel();
		try {
			hotel = hotelDAO.findById(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return hotel;
	}

	@Override
	public void create(Hotel hotel) throws Exception {
		try {
			hotelDAO.save(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void update(Hotel hotel) throws Exception {
		try {
			hotelDAO.update(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(String hotelId) throws Exception {
		try {
			Hotel hotel = hotelDAO.findById(hotelId);
			hotelDAO.delete(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
