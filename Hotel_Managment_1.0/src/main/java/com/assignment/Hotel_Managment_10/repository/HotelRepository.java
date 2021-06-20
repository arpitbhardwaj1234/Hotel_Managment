package com.assignment.Hotel_Managment_10.repository;

import com.assignment.Hotel_Managment_10.model.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelModel, Long>, HotelCustomRepository{
}
