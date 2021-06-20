package com.assignment.Hotel_Managment_10.dto;

public class HotelDTO {
    private String hotelName;

    private String locatedAt;

    private Boolean isACAvailable;

    private Boolean isMealAvailable;

    private Long totalRooms;

    private Long stars;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocatedAt() {
        return locatedAt;
    }

    public void setLocatedAt(String locatedAt) {
        this.locatedAt = locatedAt;
    }

    public Long getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Long totalRooms) {
        this.totalRooms = totalRooms;
    }

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

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }
}
