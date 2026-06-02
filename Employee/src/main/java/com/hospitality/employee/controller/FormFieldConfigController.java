package com.hospitality.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospitality.core.FormFieldConfig;
import com.hospitality.core.Hotel;
import com.hospitality.employee.bo.FormFieldConfigBO;

@RestController
@RequestMapping("/employee/form-config")
public class FormFieldConfigController {

    @Autowired
    private FormFieldConfigBO formFieldConfigBO;

    @GetMapping(value = "/list", produces = "application/json")
    public ResponseEntity<List<FormFieldConfig>> getConfig(
            @RequestParam(value = "hotelId") String hotelId,
            @RequestParam(value = "entityType", defaultValue = "employee") String entityType) {
        try {
            List<FormFieldConfig> configs = formFieldConfigBO.getByHotelAndEntity(hotelId, entityType);
            if (configs == null || configs.isEmpty()) {
                configs = formFieldConfigBO.getDefaultConfig(entityType);
            }
            return ResponseEntity.ok(configs);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseEntity<Void> saveConfig(
            @RequestParam String hotelId,
            @RequestParam(defaultValue = "employee") String entityType,
            @RequestBody List<FormFieldConfig> configs) {
        try {
            Hotel hotel = new Hotel();
            hotel.setHotelId(hotelId);
            for (FormFieldConfig cfg : configs) {
                cfg.setHotel(hotel);
                cfg.setEntityType(entityType);
            }
            formFieldConfigBO.saveAll(configs);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
