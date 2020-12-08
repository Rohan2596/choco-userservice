package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.exception.CustomerException;
import com.spatalabz.choco.userservice.model.Customer;
import com.spatalabz.choco.userservice.repository.CustomerRepository;
import com.spatalabz.choco.userservice.utility.TokenUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private TokenUtility tokenUtility;

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
         this.customer.setCustomer_Id("dsfs");

    }


    //adding customer
    @Test
    public  void givenValidCustomer_whenAdded_shouldReturnValidResponse(){
        when(passwordEncoder.encode(any())).thenReturn("7894561230");
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(null));
        Assertions.assertEquals("Customer Added.",this.customerService.addingCustomer(this.addCustomerDto));

    }

    @Test
    public  void givenValidCustomerAlreadyExist_whenAdded_shouldReturnValidResponse(){
     try {
         when(passwordEncoder.matches(any(),any())).thenReturn(true);
         when(customerRepository.save(any())).thenReturn(this.customer);
         when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
         this.customerService.addingCustomer(this.addCustomerDto);

     }catch (CustomerException customerException){

         Assertions.assertEquals("CUSTOMER_ALREADY_EXIST",customerException.exceptionTypes.name());
     }

    }

    //login customer
    @Test
    public void givenValidCustomer_whenAuthenticated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(passwordEncoder.matches(any(),any())).thenReturn(true);
        when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        when(tokenUtility.generateToken(any())).thenReturn("token");
        Assertions.assertEquals("token",this.customerService.authenticationCustomer(this.authCustomerDto));
    }

    @Test
    public void givenValidCustomerWrongEmail_whenAuthenticated_shouldReturnValidResponse(){
     try {
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(null));
        when(tokenUtility.generateToken(any())).thenReturn("sdfsdfdsfsd");
        this.customerService.authenticationCustomer(this.authCustomerDto);
    }catch (CustomerException customerException){

        Assertions.assertEquals("CUSTOMER_DOESNOT_EXIST",customerException.exceptionTypes.name());
     }
    }


    //email Address forgotten
    @Test
    public void givenValidCustomerEmailAddress_whenForgotten_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        Assertions.assertEquals("Reset link is send to registered Email Address.",this.customerService.passwordForgotten(this.addCustomerDto.emailAddress));

    }

    @Test
    public void givenInValidCustomerEmailAddress_whenForgotten_shouldReturnValidResponse(){
        try {

            when(customerRepository.save(any())).thenReturn(this.customer);
            when(customerRepository.findByEmailAddress(any())).thenReturn(java.util.Optional.ofNullable(null));
            this.customerService.passwordForgotten(this.addCustomerDto.emailAddress);

        }catch (CustomerException customerException){

            Assertions.assertEquals("CUSTOMER_DOESNOT_EXIST",customerException.exceptionTypes.name());
        }

    }

    //reset password
    @Test
    public void givenValidCustomerResetPassword_whenUpdated_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        when(tokenUtility.decodeToken(any())).thenReturn("sdfsdfdsfsd");

        Assertions.assertEquals("Password Updated Successfully.",this.customerService.resetPassword(this.resetPasswordDto,"token"));

    }
    @Test
    public void givenInValidCustomerResetPassword_whenUpdated_shouldReturnValidResponse(){
        try {
            when(customerRepository.save(any())).thenReturn(this.customer);
            when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(null));
            when(tokenUtility.decodeToken(any())).thenReturn("sdfsdfdsfsd");
            this.customerService.resetPassword(this.resetPasswordDto,"token");
        }catch (CustomerException customerException){
            Assertions.assertEquals("CUSTOMER_DOESNOT_EXIST",customerException.exceptionTypes.name());

        }

    }
    @Test
    public void givenInValidCustomerResetPassword_DTO_whenUpdated_shouldReturnValidResponse(){
        this.resetPasswordDto.confirm_password="78945612er";
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(customer));
        when(tokenUtility.decodeToken(any())).thenReturn("sdfsdfdsfsd");
        Assertions.assertEquals("Passwords doesn't matches each other.",this.customerService.resetPassword(this.resetPasswordDto,"token"));

    }


    //customer details
    @Test
    public void givenValidToken_whenGetting_shouldReturnValidResponse(){
        when(customerRepository.save(any())).thenReturn(this.customer);
        when(tokenUtility.decodeToken(any())).thenReturn("sdfsdfdsfsd");
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(this.customer));
        Assertions.assertEquals("Rohan",this.customerService.customerDetails("token").getFirstName());
    }

    @Test
    public void givenInValidToken_whenGetting_shouldReturnValidResponse(){
        try{
        when(tokenUtility.decodeToken(any())).thenReturn("sdfsdfdsfsd");
        when(customerRepository.findById(any())).thenReturn(java.util.Optional.ofNullable(null));
        this.customerService.customerDetails("token");
    }catch (CustomerException customerException){
            Assertions.assertEquals("CUSTOMER_DOESNOT_EXIST",customerException.exceptionTypes.name());

        }
    }
}
