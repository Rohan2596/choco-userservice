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



    @Autowired
    private  CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenUtility tokenUtility;


    public String addingCustomer(AddCustomerDto addCustomerDto) throws CustomerException{
         Customer customer=new Customer(addCustomerDto);
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(addCustomerDto.emailAddress);
        if(customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_ALREADY_EXIST);
          customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        return "Customer Added.";
    }

    public String authenticationCustomer(AuthCustomerDto authCustomerDto)  {
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(authCustomerDto.emailAddress);
        if(!customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);
        boolean passwordCheck=passwordEncoder.matches(authCustomerDto.password,customerExist.get().getPassword());
        if(!passwordCheck){
            return "Password Incorrect!";
        }
       return tokenUtility.generateToken(customerExist.get().get_id());

    }

    public String passwordForgotten(String emailId){
        Optional<Customer> customerExist=customerRepository.findByEmailAddress(emailId);
        if(!customerExist.isPresent())
            throw  new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST);
        return "Reset link is send to registered Email Address.";
    }

    public String resetPassword(ResetPasswordDto resetPasswordDto,String token){
        if(!resetPasswordDto.confirm_password.equals(resetPasswordDto.password)){
            return "Passwords doesn't matches each other.";
        }

        String customer_Id=tokenUtility.decodeToken(token);
        Customer customer=customerRepository.findById(customer_Id)
                .orElseThrow(
                        ()->new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST)
                );


        customer.setPassword(passwordEncoder.encode(resetPasswordDto.password));
        customer.setFirstName("QWERTY");
//for error keeping id name same equals _id
        customerRepository.save(customer);
        return "Password Updated Successfully.";
    }

    public Customer customerDetails(String token){
        String customer_Id=tokenUtility.decodeToken(token);
        Customer customer=customerRepository.findById(customer_Id)
                .orElseThrow(
                        ()->new CustomerException( CustomerException.ExceptionTypes.CUSTOMER_DOESNOT_EXIST)
                );
        return customer;
    }

}
