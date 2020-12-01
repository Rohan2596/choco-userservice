package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
public class AuthCustomerDto {

    @NotNull(message = "Email Address Cannot be empty/blank/null!")
    @Email(message = "Please Enter Valid Email Address!",
            regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$")
    public  String emailAddress;

    @NotNull(message = "Password Length must between 6 to 10 characters!")
    @Pattern(message = "Please Enter Valid  Password!",
             regexp = "^[a-zA-Z0-9]{6,10}$")
    public String password;

    @Override
    public String toString() {
        return "AuthCustomerDto{" +
                "emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
