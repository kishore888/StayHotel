package com.hospitality.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.core.Hotel;
import com.hospitality.hotel.bo.HotelBO;

@RestController
@RequestMapping("/admin/hotel")
public class HotelController {

	@Autowired
	private HotelBO hotelBO;

	@GetMapping("/list")
	public ResponseEntity<List<Hotel>> retrieveList() {
		List<Hotel> hotelList = null;
		try {
			hotelList = hotelBO.retrieveList();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(hotelList);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> retrieveById(@PathVariable String hotelId) {
		Hotel hotel = null;
		try {
			hotel = hotelBO.retrieveById(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(hotel);
	}

	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Hotel hotel) {
		try {
			hotelBO.create(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Hotel created successfully");
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Hotel hotel) {
		try {
			hotelBO.update(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Hotel updated successfully");
	}

	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<String> delete(@PathVariable String hotelId) {
		try {
			hotelBO.delete(hotelId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("Hotel deleted successfully");
	}

}
