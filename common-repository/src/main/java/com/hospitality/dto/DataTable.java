package com.hospitality.dto;

public class DataTable {
	private int iDisplayLength;
	private Boolean processing;
	private Boolean filter;
//	private Boolean orderMulti;
	
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	public Boolean getProcessing() {
		return processing;
	}
	public void setProcessing(Boolean processing) {
		this.processing = processing;
	}
	public Boolean getFilter() {
		return filter;
	}
	public void setFilter(Boolean filter) {
		this.filter = filter;
	}

}
