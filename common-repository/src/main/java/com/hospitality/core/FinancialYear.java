package com.hospitality.core;

import java.io.Serializable;
import jakarta.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.hospitality.util.BaseEntity;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Data;

import java.util.Date;


/**
 * The persistent class for the financial_year database table.
 * 
 */
@Entity
@Table(name="financial_year")
//@NamedQuery(name="FinancialYear.findAll", query="SELECT f FROM FinancialYear f")
@JsonIdentityInfo(generator = JSOGGenerator.class)
@Data
public class FinancialYear extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="financial_year_id")
	private String financialYearId;

	@Column(name="year_name")
	private String yearName;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="start_date")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="end_date")
	private Date endDate;

	public FinancialYear() {
	}

}