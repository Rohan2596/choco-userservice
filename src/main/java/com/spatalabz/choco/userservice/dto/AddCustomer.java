package com.spatalabz.choco.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AddCustomer {

    public  String userName;
    public String firstName;
    public String password;
    public  String mobileNumber;

    @Override
    public String toString() {
        return "AddCustomer{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
