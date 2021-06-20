package com.assignment.Hotel_Managment_10.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class CommentModel {
    private static  final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long commentId;
    private Long rating;
    private String description;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hotel_id_fk")
    @JsonIgnore
    private HotelModel hotel;

   // @ManyToOne(fetch=FetchType.LAZY)
  //  @JoinColumn(name="user_id_fk")
  //  @JsonIgnore
  //  private UserModel userModel;

    private Long userId;

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object obj)
    {
        CommentModel commentModel=(CommentModel)obj;
        return this.commentId==commentModel.commentId;
    }

}
