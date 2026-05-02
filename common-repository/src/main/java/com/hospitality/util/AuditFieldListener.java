package com.hospitality.util;

import java.util.Date;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditFieldListener {

	@PrePersist
	public void persistAuditFields(AuditFields<Object> auditFields){
		String userName = getUserName();
		auditFields.setCreatedBy(userName);
		auditFields.setCreatedOn(new Date());
		auditFields.setUpdatedBy(userName);
		auditFields.setUpdatedOn(new Date());
	}
	
	@PreUpdate
	public void updateAuditFields(AuditFields<Object> auditFields){
		String userName = getUserName();
		auditFields.setUpdatedBy(userName);
		auditFields.setUpdatedOn(new Date());
	}
	
	public String getUserName(){
//		String userName = "unknown";
		String userName = "kishore";
		try{
//		UserDetails userDetails = SecurityContextHolder.getContext().getAuthentication().getPrinciplal();
//		userName = userDetails.getUserName();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userName;
	}
}
