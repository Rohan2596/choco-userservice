package com.spatalabz.choco.userservice.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

     private  CustomerController customerController;
     @Autowired
     private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.customerController=new CustomerController();
    }

    @Test
    void givenValidCustomer_whenAdded_shouldReturnValidResponse() throws Exception {
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        Assertions.assertEquals("User Added.",mvcResult.getResponse().getContentAsString());

    }
}
