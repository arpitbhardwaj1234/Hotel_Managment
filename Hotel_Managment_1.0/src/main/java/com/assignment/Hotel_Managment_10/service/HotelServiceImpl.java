package com.assignment.Hotel_Managment_10.service;

import com.assignment.Hotel_Managment_10.dto.CommentDTO;
import com.assignment.Hotel_Managment_10.dto.HotelDTO;
import com.assignment.Hotel_Managment_10.dto.ResponseDTO;
import com.assignment.Hotel_Managment_10.model.CommentModel;
import com.assignment.Hotel_Managment_10.model.HotelModel;
import com.assignment.Hotel_Managment_10.repository.CommentRepository;
import com.assignment.Hotel_Managment_10.repository.HotelRepository;
import com.assignment.Hotel_Managment_10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HotelServiceImpl implements  HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public HotelModel createHotel(HotelDTO hotelDTO)
    {
        HotelModel hotel=new HotelModel();
        hotel.setHotelName(hotelDTO.getHotelName());
        hotel.setAvailaleRooms(hotelDTO.getTotalRooms());
        hotel.setBookedRooms(0L);
        System.out.println(hotelDTO.getACAvailable());
        hotel.setACAvailable(hotelDTO.getACAvailable());
        hotel.setMealAvailable(hotelDTO.getMealAvailable());
        hotel.setLocatedAt(hotelDTO.getLocatedAt());
        hotel.setStars(hotelDTO.getStars());
        hotel.setTotalComments(0L);
        return hotelRepository.save(hotel);
    }

    @Override
    public ResponseDTO addComment(Long id, CommentDTO commentDTO)
    {
        ResponseDTO res=new ResponseDTO();
        HotelModel hotel =hotelRepository.findById(id).get();
        if(hotel!=null) {
            CommentModel commentModel = new CommentModel();
            commentModel.setHotel(hotel);
     //       UserModel user = userRepository.findById(commentDTO.getUserId()).get();
   //         if (user != null) {
                commentModel.setUserId(commentDTO.getUserId());
                commentModel.setDescription(commentDTO.getDescription());
                commentModel.setRating(commentDTO.getRating());
                Set<CommentModel> set = hotel.getComments();
                if (set == null) {
                    set = new HashSet<CommentModel>();
                }
                set.add(commentModel);
                hotel.setComments(set);
                hotel.setTotalComments(hotel.getTotalComments() + 1);
                hotel.setOverAllRettings(hotel.getOverAllRettings() + commentDTO.getRating() / hotel.getTotalComments());
                hotelRepository.save(hotel);
                res.setMessage("Comment added Successfully");
     //       }
        }
        else
        {
            res.setMessage("Please enter a valid message");
        }
         return res;
        }

        @Override
        public List<HotelModel> getAll(Boolean isMealAvailable,Boolean isACAvaileable,String locatedAt)
        {
            String query=createHotelQuery(isMealAvailable,isACAvaileable,locatedAt);
            System.out.println("Query is "+query);
            return hotelRepository.getHotels(query);
        }

        @Override
        public ResponseDTO deleteComment(Long id)
        {
            ResponseDTO resposeDTO=new ResponseDTO();
            CommentModel commentModel=commentRepository.findById(id).get();
            HotelModel hotelModel=commentModel.getHotel();
            hotelModel.setTotalComments(hotelModel.getTotalComments()-1);
            Long retting=(hotelModel.getOverAllRettings()*(hotelModel.getTotalComments()+1)-
                    commentModel.getRating())/hotelModel.getTotalComments();
            hotelModel.setOverAllRettings(retting);
        Set<CommentModel> comments=hotelModel.getComments();
        System.out.println("The size of comment is "+comments.size());
          comments.remove(commentModel);
            System.out.println("The size of comment  after is "+comments.size());

            hotelModel.setComments(comments);
          hotelRepository.save(hotelModel);
          commentRepository.deleteById(id);
          resposeDTO.setMessage("Comment deleted successfuly");
          return resposeDTO;
        }

        private String createHotelQuery(Boolean isMealAvailable,Boolean isACAvailable,String locatedAt)
        {
            StringBuilder str=new StringBuilder("Select h.id,h.hotel_name,h.availale_rooms,h.isacavailable,h.ismealavailable,h.booked_rooms, h.total_comments,  h.stars, h.over_All_Rettings " +
                    ", ( select array_agg((c.description,c.id, c.rating, c.user_Id)) from comments " +
                    "c where c.hotel_id_fk=h.id)  as comments " +
                    " from hotel_details h");
            return str.toString();
        }

    }

