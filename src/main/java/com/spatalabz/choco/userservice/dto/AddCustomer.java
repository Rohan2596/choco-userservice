package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
public class AddCustomer {


    @Email(message = "Please Enter Valid Email Address!",
            regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$")
    @NotBlank(message = "Email Address Cannot be empty/blank/null!")
    @NotEmpty(message = "Email Address Cannot be empty/blank/null!")
    @NotNull(message = "Email Address Cannot be empty/blank/null!")
    public  String emailAddress;
    public String firstName;
    public String password;
    public  String mobileNumber;

    @Override
    public String toString() {
        return "AddCustomer{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
