package com.hospitality.util;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditFieldListener.class)
public class AuditFields<T> implements Serializable, Comparable<T> {

	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, updatable = false)
	private Date createdOn;
	
	@Column(name = "updated_by", nullable = false, updatable = false)
	private String updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on", nullable = false, updatable = false)
	private Date updatedOn;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
