package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements  CustomerService {

    private Customer customer;

    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public String addingCustomer(AddCustomerDto addCustomerDto){
        this.customer=new Customer(addCustomerDto);
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(addCustomerDto.emailAddress);
        if(customerExist.isPresent())
            return "Customer Already Exists!";
        String pass=passwordEncoder.encode(this.customer.getPassword());
        System.out.println(pass);
        customerRepository.save(this.customer);
        return "Customer Added.";
    }

    public String authenticationCustomer(AuthCustomerDto authCustomerDto){
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(authCustomerDto.emailAddress);
        if(!customerExist.isPresent())
            return "Customer doesn't Exists!";
        if(passwordEncoder.matches(authCustomerDto.password,customerExist.get().getPassword())){
            return "Password Incorrect!";
        }

        return "Customer Authenticated.";
    }

    public String passwordForgotten(String emailId){
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(emailId);
        if(!customerExist.isPresent())
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
