package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public String addingCustomer(AddCustomer addCustomer){
        System.out.println(addCustomer);
        return "Customer Added.";
    }
}
