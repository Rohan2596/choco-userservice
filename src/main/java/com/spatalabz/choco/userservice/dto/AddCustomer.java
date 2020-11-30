package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
public class AddCustomer {


    @NotBlank(message = "Email Address Cannot be empty/blank/null!")
    @NotEmpty(message = "Email Address Cannot be empty/blank/null!")
    @NotNull(message = "Email Address Cannot be empty/blank/null!")
    @Email(message = "Please Enter Valid Email Address!",
            regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$")
    public  String emailAddress;

    @NotNull(message = "First Name Length must between 3 to 10 characters!")
    @Pattern(message = "Please Enter Valid  First Name!",
    regexp = "^[a-zA-Z0-9]{3,10}$")
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
