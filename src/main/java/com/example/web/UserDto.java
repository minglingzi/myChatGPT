package com.example.web;

import com.opencsv.bean.CsvBindByName;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserDto {

    @CsvBindByName(column = "name")
    @NotBlank(message = "Name must not be blank")
    private String name;

    @CsvBindByName(column = "email")
    @Email(message = "Invalid email format")
    private String email;

    public UserDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

