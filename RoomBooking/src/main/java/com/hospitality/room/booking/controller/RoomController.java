package com.hospitality.room.booking.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.core.Hotel;
import com.hospitality.core.HotelPaymentGateway;
import com.hospitality.core.Room;
import com.hospitality.room.booking.bo.RoomBO;
import com.hospitality.room.booking.bo.RoomTypeBO;

//import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSession;


@RestController
@EnableFeignClients
//@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/room/")
public class RoomController {
	
//	@Autowired
//	private PaymentClient paymentClient;
	
	@Autowired
	private RoomBO roomBO;
	
	@Autowired
	private RoomTypeBO roomTypeBO;
	
//	@Autowired
//	private HotelPlanMasterBO hotelPlanMasterBO;
//	
//	@Autowired
//	private HotelPaymentGatewayBO hotelPaymentGatewayBO;
	
//	@Autowired
//	private PaymentAccountBO paymentAccountBO;
	
	@GetMapping(value="roomModule")
	public List<Room> testMethod() {
		return new ArrayList<>();
	}
	
//	@GetMapping(value="create")
//	public ModelAndView showCreateRoom(String roomId, HttpSession session){
//		Room room = null;
//		Hotel hotel = null;
//		List<RoomType> roomTypeList = null;
//		List<HotelPlanMaster> hotelPlanMasterList = new ArrayList<>();
//		List<PaymentAccount> paymentAccountList = new ArrayList<>();
//		try{
//			hotel = (Hotel)session.getAttribute("hotelObj");
//			if(StringUtils.isNotBlank(roomId)) {
//				room = roomBO.retrieveByRoomId(roomId);
//			}
//			roomTypeList = roomTypeBO.retrieveListByYear();
//			hotelPlanMasterList = hotelPlanMasterBO.retrieveListByYear();
////			paymentAccountList = paymentAccountBO.retrieveListByHotel(hotel);
//			paymentAccountList = paymentClient.retrievePaymentList(hotel);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("CreateRoom", "roomTypeList", roomTypeList).addObject("room", room).addObject("hotelPlanMasterList", hotelPlanMasterList).addObject("paymentAccountList", paymentAccountList);
//	}
//	
	@PostMapping(value="create")
	public ResponseEntity<String> create(@RequestBody Room room){
		try{
			roomBO.create(room);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok("created Room");
//		return new ModelAndView("redirect:create?roomId="+room.getRoomId());
	}
//	
//	@GetMapping(value="retrieveRoomList")
//	public ModelAndView retrieveList(Hotel hotel, HttpSession session){
//		List<Room> roomList = new ArrayList<>();
//		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
//		try{
//			if(hotel == null) {
//				hotel = (Hotel)session.getAttribute("hotelObj");
//			}else if(StringUtils.isBlank(hotel.getHotelId())) {
//				hotel = (Hotel)session.getAttribute("hotelObj");
//			}
//			roomList = roomBO.retrieveRoomList(hotel);
//			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveActiveGatewayListByHotel(hotel);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("RoomList", "roomList", roomList).addObject("hotelPaymentGatewayList", hotelPaymentGatewayList);
//	}
	
	@GetMapping(value="retriveHotelbyId", produces = "application/json")
	public ResponseEntity<Hotel> retrieveHotelbyId(@RequestParam(value="hotelId") String hotelId){
		Hotel hotel = null;
		try{
			hotel = roomBO.retrieveHotelbyId(hotelId);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping(value="retrieveRoomList", produces = "application/json")
	public ResponseEntity<List<Room>> retrieveList(Hotel hotel, HttpSession session){
		List<Room> roomList = new ArrayList<>();
		List<HotelPaymentGateway> hotelPaymentGatewayList = new ArrayList<>();
		Map<String, List<Room>> response = new HashMap<>();
		try{
			Optional<Hotel> optionalHotel =  Optional.ofNullable(hotel);
//			if(hotel == null) {
//				hotel = (Hotel)session.getAttribute("hotelObj");
//			}else if(optionalHotel.isPresent()) {
//				hotel = (Hotel)session.getAttribute("hotelObj");
//			}
			roomList = roomBO.retrieveRoomList(hotel);
//			hotelPaymentGatewayList = hotelPaymentGatewayBO.retrieveActiveGatewayListByHotel(hotel);
			response.put("rooms", roomList);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(roomList);
	}
	
//	
//	@GetMapping(value="retrieveRoomListServersideDatatable")
//	public ModelAndView retrieveRoomListServersideDatatable(DataTableDTO dataTable, HttpSession session){
//		List<Room> roomList = new ArrayList<>();
//		Hotel hotel = null;
//		try{
//			hotel = (Hotel)session.getAttribute("hotelObj");
//			roomList = roomBO.retrieveRoomList(hotel);
////			roomList = roomBO.retrieveRoomListServersideDatatable();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return new ModelAndView("ServersideRoomList").addObject("roomList", roomList);
//	}
//	
//	@PostMapping(value="retrieveRoomListServersideDatatableAjax", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public Map<String, Object> retrieveRoomsServersideDatatableAjax(@RequestBody DataTableDTO dataTable, HttpSession httpSession){
//		List<Room> roomList = null;
//		Map<String, Object> roomMap = new HashMap<>();
//		Hotel hotel = null;
//		try{
//			hotel = (Hotel) httpSession.getAttribute("hotel");
////			roomList = roomBO.retrieveRoomList();
//			roomMap = roomBO.retrieveRoomsServersideDatatable(dataTable, hotel);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return roomMap;
//	}
	
}
