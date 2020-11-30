package com.spatalabz.choco.userservice.controller;

import com.google.gson.Gson;
import com.spatalabz.choco.userservice.dto.AddCustomer;
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
     public AddCustomer addCustomer;


     @Autowired
     private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.customerController=new CustomerController();
        this.addCustomer=new AddCustomer("rohankadam965@gmail.com","Rohan","Kadam","7894561230");

    }

    @Test
    void givenValidCustomer_whenAdded_shouldReturnValidResponse() throws Exception {
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("User Added.",mvcResult.getResponse().getContentAsString());

    }


    @Test
    void givenInValidCustomer_EmailAddress_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.emailAddress=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Email Address Cannot be empty/blank/null!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.emailAddress="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.emailAddress="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_EmailAddress_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.emailAddress="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }
    //First Name Adding User
    @Test
    void givenInValidCustomer_FirstName_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.firstName=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("First Name Length must between 3 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.firstName="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.firstName="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_FirstName_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.firstName="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.firstName="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }

    //LastName
    @Test
    void givenInValidCustomer_LastName_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.lastName=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Last Name Length must between 3 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.lastName="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.lastName="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_LastName_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.lastName="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.lastName="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }

    //password
    @Test
    void givenInValidCustomer_password_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.password=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Password Length must between 6 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.password="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.password="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_password_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.password="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomer.password="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomer))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

}
