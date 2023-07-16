package com.example.userservice.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String firstName;

    private String lastName;

    private String birthOfDate;

    private String email;

    private String role;

}
