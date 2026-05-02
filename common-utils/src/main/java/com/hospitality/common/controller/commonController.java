package com.hospitality.common.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;

import com.hospitality.common.util.MyDateFormat;

@Controller
public class commonController {
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.setAutoGrowCollectionLimit(20000);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
//		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(new MyDateFormat(), true));
		
//		DateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
//		CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat1, true);
//		DateFormat dateFormat2 = new SimpleDateFormat("MMM d, YYYY");
//		CustomDateEditor shipDateEditor = new CustomDateEditor(dateFormat2, true);
//		DateFormat dateFormat3 = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
//		CustomDateEditor dateTime = new CustomDateEditor(dateFormat3, true);
//		webDataBinder.registerCustomEditor(Date.class, "date1", orderDateEditor);
//		webDataBinder.registerCustomEditor(Date.class, "date2", shipDateEditor);
//		webDataBinder.registerCustomEditor(Date.class, "dateTime", dateTime);
	}

}
