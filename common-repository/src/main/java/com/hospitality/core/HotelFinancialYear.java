package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

import java.util.Date;


/**
 * The persistent class for the hotel_financial_year database table.
 * 
 */
@Entity
@Table(name="hotel_financial_year")
//@NamedQuery(name="HotelFinancialYear.findAll", query="SELECT h FROM HotelFinancialYear h")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class HotelFinancialYear extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="hotel_financial_year_id")
	private String hotelFinancialYearId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="financial_year_id")
	private FinancialYear financialYear;

	public HotelFinancialYear() {
	}

	public String getHotelFinancialYearId() {
		return hotelFinancialYearId;
	}

	public void setHotelFinancialYearId(String hotelFinancialYearId) {
		this.hotelFinancialYearId = hotelFinancialYearId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public FinancialYear getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(FinancialYear financialYear) {
		this.financialYear = financialYear;
	}

}