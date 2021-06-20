package com.assignment.Hotel_Managment_10.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="hotel_details")
public class HotelModel {

    private static  final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long hotelId;

    private String hotelName;

    private Long availaleRooms;

    private Long bookedRooms;

    private Boolean isACAvailable;

    public Boolean getACAvailable() {
        return isACAvailable;
    }

    public void setACAvailable(Boolean ACAvailable) {
        isACAvailable = ACAvailable;
    }

    public Boolean getMealAvailable() {
        return isMealAvailable;
    }

    public void setMealAvailable(Boolean mealAvailable) {
        isMealAvailable = mealAvailable;
    }

    private Boolean isMealAvailable;

    private String locatedAt;
// does the hotel 1-Star, 2-Star ,3-Star
    private Long stars;

    private Long totalComments;

    private Long overAllRettings;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Long getAvailaleRooms() {
        return availaleRooms;
    }

    public void setAvailaleRooms(Long availaleRooms) {
        this.availaleRooms = availaleRooms;
    }

    public Long getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(Long bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public String getLocatedAt() {
        return locatedAt;
    }

    public void setLocatedAt(String locatedAt) {
        this.locatedAt = locatedAt;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }

    public Long getTotalComments() {
        return totalComments;
    }

    public void setTotalComments(Long totalComments) {
        this.totalComments = totalComments;
    }

    public Set<CommentModel> getComments() {
        return comments;
    }

    public void setComments(Set<CommentModel> comments) {
        this.comments = comments;
    }


    public Long getOverAllRettings() {
        return overAllRettings;
    }

    public void setOverAllRettings(Long overAllRettings) {
        this.overAllRettings = overAllRettings;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "hotel")
    private Set<CommentModel> comments;
}
