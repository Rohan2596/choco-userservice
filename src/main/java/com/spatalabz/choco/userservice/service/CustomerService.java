package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public String addingCustomer(AddCustomerDto addCustomerDto){
        System.out.println(addCustomerDto);
        return "Customer Added.";
    }
}
