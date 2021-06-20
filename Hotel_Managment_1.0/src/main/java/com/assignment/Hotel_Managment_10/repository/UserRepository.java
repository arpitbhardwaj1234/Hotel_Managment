package com.assignment.Hotel_Managment_10.repository;

import com.assignment.Hotel_Managment_10.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {
}