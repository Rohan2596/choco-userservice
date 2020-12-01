package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerDto {


    @NotNull(message = "Email Address Cannot be empty/blank/null!")
    @Email(message = "Please Enter Valid Email Address!",
            regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$")
    public  String emailAddress;

    @NotNull(message = "First Name Length must between 3 to 10 characters!")
    @Pattern(message = "Please Enter Valid  First Name!",
    regexp = "^[a-zA-Z0-9]{3,10}$")
    public String firstName;

    @NotNull(message = "Last Name Length must between 3 to 10 characters!")
    @Pattern(message = "Please Enter Valid Last Name!",
            regexp = "^[a-zA-Z0-9]{3,10}$")
    public String lastName;


    @NotNull(message = "Password Length must between 6 to 10 characters!")
    @Pattern(message = "Please Enter Valid  Password!",
            regexp = "^[a-zA-Z0-9]{6,10}$")
    public String password;


    @Override
    public String toString() {
        return "AddCustomer{" +
                "emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
