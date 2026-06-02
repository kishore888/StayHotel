package com.hospitality.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hospitality.core.FormFieldConfig;
import com.hospitality.dao.FormFieldConfigDAO;

import jakarta.persistence.Query;

@Repository
@Transactional
public class FormFieldConfigDAOImpl extends GenericDAOImpl<FormFieldConfig> implements FormFieldConfigDAO {

    @Override
    public List<FormFieldConfig> findByHotelAndEntity(String hotelId, String entityType) throws Exception {
        List<FormFieldConfig> result = new ArrayList<>();
        try {
            String jpql = "SELECT f FROM FormFieldConfig f JOIN FETCH f.hotel h " +
                          "WHERE h.hotelId = :hotelId AND f.entityType = :entityType " +
                          "ORDER BY f.fieldOrder ASC";
            Query query = entityManager.createQuery(jpql);
            query.setParameter("hotelId", hotelId);
            query.setParameter("entityType", entityType);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
