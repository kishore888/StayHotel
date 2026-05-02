package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


/**
 * The persistent class for the department database table.
 * 
 */
@Entity
@Table(name="department")
//@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Department extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="department_id")
	private String departmentId;

	@Column(name="department_name")
	private String departmentName;

	@Column(name="description")
	private String description;

	@Column(name="short_name")
	private String shortName;
	
	//bi-directional many-to-one association to Hotel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	public Department() {
	}

	public String getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}