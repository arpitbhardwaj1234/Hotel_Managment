package com.assignment.Hotel_Managment_10.repository;

import com.assignment.Hotel_Managment_10.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentModel, Long> {
}