package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest  {

    private CustomerService customerService;
    private AddCustomerDto addCustomerDto;
    private AuthCustomerDto authCustomerDto;
    private ResetPasswordDto resetPasswordDto;

    @BeforeEach
    void setUp() {
        this.customerService=new CustomerService();
        this.addCustomerDto =new AddCustomerDto("rohankadam965@gmail.com","Rohan","Kadam","7894561230","SUPPLIER");
        this.authCustomerDto=new AuthCustomerDto("rohankadam965@gmail.com","7894561230");
        this.resetPasswordDto=new ResetPasswordDto("7894561230","78945612we");

    }

    @Test
    public  void givenValidCustomer_whenAdded_shouldReturnValidResponse(){
            this.customerService.addingCustomer(this.addCustomerDto);


    }

    @Test
    public void givenValidCustomer_whenAuthenticated_shouldReturnValidResponse(){
        this.customerService.authenticationCustomer(this.authCustomerDto);
    }

    @Test
    public void givenValidCustomerEmailAddress_whenForgotten_shouldReturnValidResponse(){
        this.customerService.passwordForgotten("rohanKadam965@gmail.com");
    }

    @Test
    public void givenValidCustomerResetPassword_whenUpdated_shouldReturnValidResponse(){
        this.customerService.resetPassword(this.resetPasswordDto);
    }

    @Test
    public void givenValidToken_whenGetting_shouldReturnValidResponse(){
        this.customerService.customerDetails("token");
    }
}
