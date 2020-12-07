package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements  CustomerService {

    private Customer customer;

    @Autowired
    private  CustomerRepository customerRepository;



    public String addingCustomer(AddCustomerDto addCustomerDto){
        this.customer=new Customer(addCustomerDto);
        boolean exist=customerRepository.findAllByEmailAddress(addCustomerDto.emailAddress);
        if(exist)
            return "Customer Already Exists!";
        customerRepository.save(this.customer);
        return "Customer Added.";
    }

    public String authenticationCustomer(AuthCustomerDto authCustomerDto){
        boolean exist=customerRepository.findAllByEmailAddress(authCustomerDto.emailAddress);
        if(!exist)
            return "Customer doesn't Exists!";
        return "Customer Authenticated.";
    }

    public String passwordForgotten(String emailId){
        return "Password Forgotten.";
    }

    public String resetPassword(ResetPasswordDto resetPasswordDto){
        return "Password Updated Succesfully.";
    }

    public String customerDetails(String token){
        return "Customer Details";
    }

}
