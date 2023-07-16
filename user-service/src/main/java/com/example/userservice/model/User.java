package com.example.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    private String id;

    private String userName;

    @JsonIgnore()
    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private String birthOfDate;

    private String role;
}
