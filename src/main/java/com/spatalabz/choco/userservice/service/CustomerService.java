package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public String addingCustomer(AddCustomerDto addCustomerDto){
        System.out.println(addCustomerDto);
        return "Customer Added.";
    }

    public String authenticationCustomer(AuthCustomerDto authCustomerDto){
        System.out.println(authCustomerDto);
        return "Customer Authenticated.";
    }

    public String passwordForgotten(String emailId){
        return "Password Forgotten.";
    }


}
