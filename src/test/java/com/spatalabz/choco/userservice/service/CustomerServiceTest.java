package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest  {

    private CustomerService customerService;
    private AddCustomerDto addCustomerDto;
    private AuthCustomerDto authCustomerDto;

    @BeforeEach
    void setUp() {
        this.customerService=new CustomerService();
        this.addCustomerDto =new AddCustomerDto("rohankadam965@gmail.com","Rohan","Kadam","7894561230");
        this.authCustomerDto=new AuthCustomerDto("rohankadam965@gmail.com","7894561230");

    }

    @Test
    public  void givenValidCustomer_whenAdded_shouldReturnValidResponse(){
            this.customerService.addingCustomer(this.addCustomerDto);


    }

    public void givenValidCustomer_whenAuthenticated_shouldReturnValidResponse(){
        this.customerService.authenticationCustomer(this.authCustomerDto);
    }
}
