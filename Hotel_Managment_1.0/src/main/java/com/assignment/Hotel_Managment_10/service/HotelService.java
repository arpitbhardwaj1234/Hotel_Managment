package com.assignment.Hotel_Managment_10.service;

import com.assignment.Hotel_Managment_10.dto.CommentDTO;
import com.assignment.Hotel_Managment_10.dto.HotelDTO;
import com.assignment.Hotel_Managment_10.dto.ResponseDTO;
import com.assignment.Hotel_Managment_10.model.HotelModel;

import java.util.List;

public interface HotelService {

    public HotelModel createHotel(HotelDTO hotelDTO);

    public ResponseDTO addComment(Long id, CommentDTO commentDTO);

    public List<HotelModel> getAll(Boolean isMealAvailable,Boolean isACAvailable,String locatedAt);

    public ResponseDTO deleteComment(Long id);
}
