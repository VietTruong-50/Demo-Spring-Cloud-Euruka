package com.example.userservice.service.impl;

import com.example.userservice.config.ClientInterceptor;
import com.example.userservice.controller.request.UserDTO;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import com.example.userservice.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private final String TOKEN_SECRET = "demo-spring-cloud";


    @Override
    public User getUserDetails() {
        String token = ClientInterceptor.getBearerTokenHeader().replace("Bearer ", "");

        Jws<Claims> jws = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);
        return userRepository.findByUserName(jws.getBody().getSubject()).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @Override
    public User updateProfile(UserDTO userDTO) {
        String token = ClientInterceptor.getBearerTokenHeader().replace("Bearer ", "");

        Jws<Claims> jws = Jwts.parser().setSigningKey(TOKEN_SECRET).parseClaimsJws(token);

        User updatedUser = userRepository.findByUserName(jws.getBody().getSubject()).orElseThrow(() -> new RuntimeException("user not found"));

        updatedUser.setEmail(userDTO.getEmail());
        updatedUser.setBirthOfDate(userDTO.getBirthOfDate());
        updatedUser.setFirstName(userDTO.getFirstName());
        updatedUser.setLastName(userDTO.getLastName());

        return userRepository.save(updatedUser);
    }
}
