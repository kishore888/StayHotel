package com.hospitality.util;

import java.lang.reflect.Field;
import java.security.SecureRandom;

import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import org.apache.commons.lang.StringUtils;

public class PrimaryKeyListener {

	@PrePersist
	public void preUpdate(BaseEntity entity){
		try{
			Field f = getFieldByAnnotation(entity);
			f.setAccessible(true);
			Object pkValue = f.get(entity);
			String pk = pkValue == null?null : pkValue.toString();
			
			if(!StringUtils.isNotBlank(pk)){
				f.set(entity, smartPkey());
				f.setAccessible(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	Field getFieldByAnnotation(BaseEntity entity){
		for(Field f : entity.getClass().getDeclaredFields()){
			if(f.isAnnotationPresent(Id.class)){
				return f;
			}
		}
		return null;
	}
	
	public static String smartPkey(){
		long unixTime = System.currentTimeMillis()/10L;
		String pkey = randomString(4)+Long.toHexString(unixTime).toUpperCase()+randomString(4);
		return pkey;
	}
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom secureRandom = new SecureRandom();
	public static String randomString(int length){
		StringBuilder sb = new StringBuilder(length);
		for(int i=0;i<length;i++){
			sb.append(AB.charAt(secureRandom.nextInt(AB.length())));
		}
		return sb.toString();
	}
}
