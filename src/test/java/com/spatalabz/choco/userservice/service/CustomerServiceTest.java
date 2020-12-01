package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerServiceTest  {

    private CustomerService customerService;
    private AddCustomerDto addCustomerDto;

    @BeforeEach
    void setUp() {
        this.customerService=new CustomerService();
        this.addCustomerDto =new AddCustomerDto("rohankadam965@gmail.com","Rohan","Kadam","7894561230");

    }

    @Test
    public  void givenValidCustomer_whenAdded_shouldReturnValidResponse(){
            this.customerService.addingCustomer(this.addCustomerDto);


    }
}
