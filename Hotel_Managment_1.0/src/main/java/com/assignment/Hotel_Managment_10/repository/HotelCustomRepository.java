package com.assignment.Hotel_Managment_10.repository;

import com.assignment.Hotel_Managment_10.model.HotelModel;

import java.util.List;

public interface HotelCustomRepository {
    public List<HotelModel> getHotels(String query);
}
