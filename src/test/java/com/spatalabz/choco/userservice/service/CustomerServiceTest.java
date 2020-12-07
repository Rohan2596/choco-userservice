package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;
    //Dtos
    private AddCustomerDto addCustomerDto;
    private AuthCustomerDto authCustomerDto;
    private ResetPasswordDto resetPasswordDto;
    //Models
    private Customer customer;



    @BeforeEach
    void setUp() {
        this.addCustomerDto =new AddCustomerDto("rohankadam965@gmail.com","Rohan","Kadam","7894561230","SUPPLIER");
        this.authCustomerDto=new AuthCustomerDto("rohankadam965@gmail.com","7894561230");
        this.resetPasswordDto=new ResetPasswordDto("78945612we","78945612we");
         this.customer=new Customer(this.addCustomerDto);
         this.customer.setId("dsfs");

    }


    //adding customer
    @Test
    public  void givenValidCustomer_whenAdded_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(false);
        Assertions.assertEquals("Customer Added.",this.customerService.addingCustomer(this.addCustomerDto));

    }

    @Test
    public  void givenValidCustomerAlreadyExist_whenAdded_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(true);
        Assertions.assertEquals("Customer Already Exists!",this.customerService.addingCustomer(this.addCustomerDto));

    }

    //login customer
    @Test
    public void givenValidCustomer_whenAuthenticated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(true);
        Assertions.assertEquals("Customer Authenticated.",this.customerService.authenticationCustomer(this.authCustomerDto));
    }

    @Test
    public void givenValidCustomerWrongEmail_whenAuthenticated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(false);
        Assertions.assertEquals("Customer doesn't Exists!",this.customerService.authenticationCustomer(this.authCustomerDto));
    }


    //email Address forgotten
    @Test
    public void givenValidCustomerEmailAddress_whenForgotten_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(true);
        Assertions.assertEquals("Reset link is send to registered Email Address.",this.customerService.passwordForgotten(this.addCustomerDto.emailAddress));

    }

    @Test
    public void givenInValidCustomerEmailAddress_whenForgotten_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findAllByEmailAddress(any())).thenReturn(false);
        Assertions.assertEquals("Customer doesn't Exists!",this.customerService.passwordForgotten(this.addCustomerDto.emailAddress));

    }

    //reset password
    @Test
    public void givenValidCustomerResetPassword_whenUpdated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        Assertions.assertEquals("Password Updated Successfully.",this.customerService.resetPassword(this.resetPasswordDto,"token"));

    }
    @Test
    public void givenInValidCustomerResetPassword_whenUpdated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(null));
        Assertions.assertEquals("Invalid Token!",this.customerService.resetPassword(this.resetPasswordDto,"token"));

    }
    @Test
    public void givenInValidCustomerResetPassword_DTO_whenUpdated_shouldReturnValidResponse(){
        this.resetPasswordDto.confirm_password="78945612er";
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(customer));
        Assertions.assertEquals("Passwords doesn't matches each other.",this.customerService.resetPassword(this.resetPasswordDto,"token"));

    }


    //customer details
    @Test
    public void givenValidToken_whenGetting_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        Assertions.assertEquals("Customer Details",this.customerService.customerDetails("token"));
    }

    @Test
    public void givenInValidToken_whenGetting_shouldReturnValidResponse(){

        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(null));
        Assertions.assertEquals("Invalid Token!",this.customerService.customerDetails("token"));
    }
}
