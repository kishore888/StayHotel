package com.hospitality.room.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hospitality.core.Room;
import com.hospitality.core.RoomType;
import com.hospitality.room.booking.bo.RoomTypeBO;

@RestController
@RequestMapping("/room/roomType/")
public class RoomTypeController {
//	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RoomTypeBO roomTypeBO;
	
	@PostMapping(value="create")
	public ResponseEntity<String> create(RoomType roomType){
		try{
			roomTypeBO.create(roomType);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("created Room Type");
	}
	
	@GetMapping(value="retrieveRoomTypes")
	public ResponseEntity<List<RoomType>>  retrieveList(){
		List<RoomType> roomTypeList = null;
		try{
			roomTypeList = roomTypeBO.retrieveListByYear();
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(roomTypeList);
	}

}
