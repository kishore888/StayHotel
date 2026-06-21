package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the hotel_financial_year database table.
 * 
 */
@Entity
@Table(name="hotel_financial_year")
//@NamedQuery(name="HotelFinancialYear.findAll", query="SELECT h FROM HotelFinancialYear h")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
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

}