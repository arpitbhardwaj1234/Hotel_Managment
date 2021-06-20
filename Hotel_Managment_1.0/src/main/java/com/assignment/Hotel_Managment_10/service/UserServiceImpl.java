package com.assignment.Hotel_Managment_10.service;

import com.assignment.Hotel_Managment_10.model.UserModel;
import com.assignment.Hotel_Managment_10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserModel createUser(UserModel user)
    {
        return userRepository.save(user);
    }
}
