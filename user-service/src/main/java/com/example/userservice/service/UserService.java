package com.example.userservice.service;

import com.example.userservice.controller.request.UserDTO;
import com.example.userservice.model.User;

public interface UserService {
    User getUserDetails();

    User updateProfile(UserDTO userDTO);
}
