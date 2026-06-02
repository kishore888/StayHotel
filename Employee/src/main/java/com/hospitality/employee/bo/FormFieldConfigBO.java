package com.hospitality.employee.bo;

import java.util.List;
import com.hospitality.core.FormFieldConfig;

public interface FormFieldConfigBO {

    List<FormFieldConfig> getByHotelAndEntity(String hotelId, String entityType) throws Exception;

    List<FormFieldConfig> getDefaultConfig(String entityType) throws Exception;

    void saveAll(List<FormFieldConfig> configs) throws Exception;

}
