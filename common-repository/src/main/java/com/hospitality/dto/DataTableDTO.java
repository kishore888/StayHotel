package com.hospitality.dto;

import java.util.List;

public class DataTableDTO {
	private Integer draw;
	private Integer start;
	private Integer length;
	private String entity;
	private String idProp;
	private Integer minRange;
	private Integer maxRange;
	private List<DataTableOrderDTO> order;
	private List<DataTableColumnDTO> columns;
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public String getIdProp() {
		return idProp;
	}
	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}
	public Integer getMinRange() {
		return minRange;
	}
	public void setMinRange(Integer minRange) {
		this.minRange = minRange;
	}
	public Integer getMaxRange() {
		return maxRange;
	}
	public void setMaxRange(Integer maxRange) {
		this.maxRange = maxRange;
	}
	public List<DataTableOrderDTO> getOrder() {
		return order;
	}
	public void setOrder(List<DataTableOrderDTO> order) {
		this.order = order;
	}
	public List<DataTableColumnDTO> getColumns() {
		return columns;
	}
	public void setColumns(List<DataTableColumnDTO> columns) {
		this.columns = columns;
	}
	
}
