package com.assignment.Hotel_Managment_10.controller;

import com.assignment.Hotel_Managment_10.model.UserModel;
import com.assignment.Hotel_Managment_10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserModel> post(@RequestBody UserModel user)
    {
        System.out.println(user);
        UserModel res=userService.createUser(user);
        return new ResponseEntity<UserModel>(res, HttpStatus.OK);
    }
}
