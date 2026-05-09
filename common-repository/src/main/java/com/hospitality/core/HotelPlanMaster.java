package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hospitality.util.BaseEntity;


/**
 * The persistent class for the hotel_plan_master database table.
 * 
 */
@Entity
@Table(name="hotel_plan_master")
//@NamedQuery(name="HotelPlanMaster.findAll", query="SELECT h FROM HotelPlanMaster h")
//@JsonInclude(Include.NON_NULL)
public class HotelPlanMaster extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hotel_plan_master_id")
	private String hotelPlanMasterId;

	@Column(name="plan_code")
	private String planCode;

	@Column(name="plan_description")
	private String planDescription;

	@Column(name="plan_name")
	private String planName;

	public HotelPlanMaster() {
	}

	public String getHotelPlanMasterId() {
		return this.hotelPlanMasterId;
	}

	public void setHotelPlanMasterId(String hotelPlanMasterId) {
		this.hotelPlanMasterId = hotelPlanMasterId;
	}

	public String getPlanCode() {
		return this.planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanDescription() {
		return this.planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

}