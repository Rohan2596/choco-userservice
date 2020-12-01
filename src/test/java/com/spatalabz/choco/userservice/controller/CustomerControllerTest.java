package com.spatalabz.choco.userservice.controller;

import com.google.gson.Gson;
import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

     public   CustomerController customerController;
     public AddCustomerDto addCustomerDto;
     public AuthCustomerDto authCustomerDto;
     public ResetPasswordDto resetPasswordDto;



     @Autowired
     private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.customerController=new CustomerController();
        this.addCustomerDto =new AddCustomerDto("rohankadam965@gmail.com","Rohan","Kadam","7894561230");
        this.authCustomerDto=new AuthCustomerDto("rohankadam965@gmail.com","789456123q");
        this.resetPasswordDto=new ResetPasswordDto("789456123q","789456123q");
    }

    @Test
    void givenValidCustomer_whenAdded_shouldReturnValidResponse() throws Exception {
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("User Added.",mvcResult.getResponse().getContentAsString());

    }

//emailAddress
    @Test
    void givenInValidCustomer_EmailAddress_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.emailAddress=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Email Address Cannot be empty/blank/null!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.emailAddress="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.emailAddress="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_EmailAddress_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.emailAddress="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }
    //First Name Adding User
    @Test
    void givenInValidCustomer_FirstName_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.firstName=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("First Name Length must between 3 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.firstName="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.firstName="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_FirstName_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.firstName="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_FirstName_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.firstName="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  First Name!",mvcResult.getResponse().getContentAsString());

    }

    //LastName
    @Test
    void givenInValidCustomer_LastName_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.lastName=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Last Name Length must between 3 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.lastName="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.lastName="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_LastName_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.lastName="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_LastName_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.lastName="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Last Name!",mvcResult.getResponse().getContentAsString());

    }

    //password
    @Test
    void givenInValidCustomer_password_null_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.password=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Password Length must between 6 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_empty_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.password="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern1_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.password="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_password_pattern2_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.password="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern3_whenAdded_shouldReturnValidResponse() throws Exception {
        this.addCustomerDto.password="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.addCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    //Authenticating User or Login
    @Test
    void givenValidCustomer_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("User Authenticated.",mvcResult.getResponse().getContentAsString());

    }

    //emailAddress
    @Test
    void givenInValidCustomer_EmailAddress_null_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.emailAddress=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Email Address Cannot be empty/blank/null!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_empty_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.emailAddress="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_EmailAddress_pattern1_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.emailAddress="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_EmailAddress_pattern2_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.emailAddress="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid Email Address!",mvcResult.getResponse().getContentAsString());

    }

    //password
    @Test
    void givenInValidCustomer_password_null_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.password=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Password Length must between 6 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_empty_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.password="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern1_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.password="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_password_pattern2_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.password="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_password_pattern3_whenAuthenticated_shouldReturnValidResponse() throws Exception {
        this.authCustomerDto.password="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/auth")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.authCustomerDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    //Password Forgotten

    @Test
    void givenValidCustomerEmailId_whenForgotten_shouldReturnValidResponse() throws Exception {

        MvcResult mvcResult=this.mockMvc.perform(get("/choco/customer/user/forgot")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("emailId","rohankadam965@gmail.com")).andReturn();
        Assertions.assertEquals("Customer Password forgotten.",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomerEmailId_whenForgotten_shouldReturnValidResponse() throws Exception {

        MvcResult mvcResult=this.mockMvc.perform(get("/choco/customer/user/forgot")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("emailId","rohankadam965gmail.com")).andReturn();
        Assertions.assertEquals("Please Enter correct Email Address!",mvcResult.getResponse().getContentAsString());

    }




    //reset password

    @Test
    void givenValidCustomer_reset_password_whenUpdated_shouldReturnValidResponse() throws Exception {

        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Password Updated  Successfully.",mvcResult.getResponse().getContentAsString());

    }


    //password
    @Test
    void givenInValidCustomer_reset_password_null_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.password=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Password Length must between 6 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_password_empty_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.password="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_password_pattern1_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.password="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_reset_password_pattern2_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.password="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_password_pattern3_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.password="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    //confirm Password

    @Test
    void givenInValidCustomer_reset_confirm_password_null_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.confirm_password=null;
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Password Length must between 6 to 10 characters!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_confirm_password_empty_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.confirm_password="";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_confirm_password_pattern1_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.confirm_password="rohankadamasd.com";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    @Test
    void givenInValidCustomer_reset_confirm_password_pattern2_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.confirm_password="rohankada@masd";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }
    @Test
    void givenInValidCustomer_reset_confirm_password_pattern3_whenUpdated_shouldReturnValidResponse() throws Exception {
        this.resetPasswordDto.confirm_password="ro";
        MvcResult mvcResult=this.mockMvc.perform(post("/choco/customer/user/reset")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(new Gson().toJson(this.resetPasswordDto))).andReturn();
        Assertions.assertEquals("Please Enter Valid  Password!",mvcResult.getResponse().getContentAsString());

    }

    //Get User Details

    @Test
    void givenInValidCustomer_whenUpdated_shouldReturnValidResponse() throws Exception {

        MvcResult mvcResult=this.mockMvc.perform(get("/choco/customer/user/dsfsdfds")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                ).andReturn();
        Assertions.assertEquals("Getting Customer Details",mvcResult.getResponse().getContentAsString());

    }


}
