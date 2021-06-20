package com.assignment.Hotel_Managment_10.repository;

import com.assignment.Hotel_Managment_10.model.HotelModel;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class HotelCustomRepositoryImpl implements HotelCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<HotelModel> getHotels(String query)
    {
        Query getHotelQuery = (Query) entityManager.createNativeQuery(query, HotelModel.class);
        return getHotelQuery.getResultList();
    }
}
