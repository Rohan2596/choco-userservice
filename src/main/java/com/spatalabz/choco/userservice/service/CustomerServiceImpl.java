package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.exception.CustomerException;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import com.spatalabz.choco.userservice.utility.TokenUtility;
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

    @Autowired
    private TokenUtility tokenUtility;


    public String addingCustomer(AddCustomerDto addCustomerDto){
        this.customer=new Customer(addCustomerDto);
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(addCustomerDto.emailAddress);
        if(customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_ALREADY_EXIST);
        passwordEncoder.encode(this.customer.getPassword());
        customerRepository.save(this.customer);
        return "Customer Added.";
    }

    public String authenticationCustomer(AuthCustomerDto authCustomerDto)  {
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(authCustomerDto.emailAddress);
        if(!customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);

        if(passwordEncoder.matches(authCustomerDto.password,customerExist.get().getPassword())){
            return "Password Incorrect!";
        }
        tokenUtility.generateToken(customerExist.get().getId());

        return "Customer Authenticated.";
    }

    public String passwordForgotten(String emailId){
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(emailId);
        if(!customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);
        return "Reset link is send to registered Email Address.";
    }

    public String resetPassword(ResetPasswordDto resetPasswordDto,String token){
        String customer_Id=tokenUtility.decodeToken(token);
        Optional<Customer> customerExist=customerRepository.findById(customer_Id);
        if(!customerExist.isPresent()){
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);
        }
        if(!resetPasswordDto.confirm_password.equals(resetPasswordDto.password)){
           return "Passwords doesn't matches each other.";
        }
        customerExist.get().setPassword(resetPasswordDto.password);
        return "Password Updated Successfully.";
    }

    public String customerDetails(String token){
        String customer_Id=tokenUtility.decodeToken(token);
        Optional<Customer> customerExist=customerRepository.findById(customer_Id);
        if(!customerExist.isPresent()){
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);
        }
        return "Customer Details";
    }

}
