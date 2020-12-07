package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        boolean exist=customerRepository.findAllByEmailAddress(emailId);
        if(!exist)
            return "Customer doesn't Exists!";
        return "Reset link is send to registered Email Address.";
    }

    public String resetPassword(ResetPasswordDto resetPasswordDto,String token){
        String customer_Id=token;
        Optional<Customer> customerExist=customerRepository.findById(customer_Id);
        if(!customerExist.isPresent()){
            return "Invalid Token!";
        }
        if(resetPasswordDto.confirm_password!=resetPasswordDto.password){
           return "Passwords doesn't matches each other.";
        }
        customerExist.get().setPassword(resetPasswordDto.password);
        return "Password Updated Successfully.";
    }

    public String customerDetails(String token){
        String customer_Id=token;
        Optional<Customer> customerExist=customerRepository.findById(customer_Id);
        if(!customerExist.isPresent()){
            return "Invalid Token!";
        }
        return "Customer Details";
    }

}
