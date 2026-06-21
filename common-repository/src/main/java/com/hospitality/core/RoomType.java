package com.hospitality.core;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;
import lombok.Data;

/**
 * The persistent class for the room_type database table.
 * 
 */
@Entity
@Table(name="room_type")
//@NamedQuery(name="RoomType.findAll", query="SELECT r FROM RoomType r")
@JsonInclude(Include.NON_NULL)
@Data
public class RoomType extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="room_type_id")
	private String roomTypeId;

	@Column(name="room_type")
	private String roomType;
	
	@Column(name="room_type_status")
	private String roomTypeStatus;

	@Column(name="room_type_tariff")
	private String roomTypeTariff;

	public RoomType() {
	}

}