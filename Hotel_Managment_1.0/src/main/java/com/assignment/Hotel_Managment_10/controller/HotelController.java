package com.assignment.Hotel_Managment_10.controller;

import com.assignment.Hotel_Managment_10.dto.CommentDTO;
import com.assignment.Hotel_Managment_10.dto.HotelDTO;
import com.assignment.Hotel_Managment_10.dto.ResponseDTO;
import com.assignment.Hotel_Managment_10.model.HotelModel;
import com.assignment.Hotel_Managment_10.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class HotelController  {
    @Autowired
    HotelService hotelService;

    @PostMapping("/hotel")
    public ResponseEntity<HotelModel> postHotel(@RequestBody HotelDTO hotelDTO)
    {
     HotelModel hotel=hotelService.createHotel(hotelDTO);
       return new ResponseEntity<HotelModel>(hotel, HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public  ResponseEntity<ResponseDTO> addComment(@RequestBody CommentDTO commentDTO)
    {
        System.out.println("Inside controller");
       ResponseDTO responseDTO= hotelService.addComment(commentDTO.getHotelId(),commentDTO);
        return new ResponseEntity<ResponseDTO>( responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteComment")
    public ResponseEntity<ResponseDTO>  deleteComment(@Param("id") Long id)
    {
      ResponseDTO res=hotelService.deleteComment(id);
      return new ResponseEntity<ResponseDTO>(res,HttpStatus.OK);
    }

    @PutMapping("/updateComment")
    public ResponseEntity<HotelModel>  updateHotel(@RequestBody HotelDTO hotelDTO)
    {
        return null;
    }



    @GetMapping("/getAll")
    public ResponseEntity<List<HotelModel>> getHotels(@RequestParam(required = false) Boolean isMealAvailable,
                                                      @RequestParam(required = false) Boolean isACAvailable, @RequestParam(required = false) String locatedAt)
    {
    List<HotelModel> res=hotelService.getAll(isMealAvailable,isACAvailable,locatedAt);
    return new ResponseEntity<List<HotelModel>>(res,HttpStatus.OK);
    }

}
