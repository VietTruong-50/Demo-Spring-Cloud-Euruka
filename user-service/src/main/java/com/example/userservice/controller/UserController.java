package com.example.userservice.controller;

import com.example.userservice.controller.request.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "",produces = "application/json")
    public User getUserDetails(){
        return userService.getUserDetails();
    }

    @PutMapping(value = "", produces = "application/json")
    public User updateProfile(@RequestBody UserDTO userDTO){
        return userService.updateProfile(userDTO);
    }

}
