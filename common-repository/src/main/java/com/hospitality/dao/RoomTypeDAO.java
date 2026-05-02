package com.hospitality.dao;

import java.util.List;

import com.hospitality.core.RoomType;

public interface RoomTypeDAO extends GenericDAO<RoomType>{

	public List<RoomType> retrieveListByYear();

}
