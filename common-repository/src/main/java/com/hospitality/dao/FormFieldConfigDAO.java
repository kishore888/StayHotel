package com.hospitality.dao;

import java.util.List;
import com.hospitality.core.FormFieldConfig;

public interface FormFieldConfigDAO extends GenericDAO<FormFieldConfig> {

    List<FormFieldConfig> findByHotelAndEntity(String hotelId, String entityType) throws Exception;

}
