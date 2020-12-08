package com.spatalabz.choco.userservice.controller;

import com.spatalabz.choco.userservice.dto.*;
import com.spatalabz.choco.userservice.response.CustomerResponse;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/choco/customer/user")
public class CustomerController {

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody @Valid AddCustomerDto addCustomerDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new CustomerResponse(bindingResult.getAllErrors().get(0).getDefaultMessage(),addCustomerDto.emailAddress), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(new CustomerResponse("User Added.",addCustomerDto),HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    public ResponseEntity<CustomerResponse> authenticatingCustomer(@RequestBody @Valid AuthCustomerDto authCustomerDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new CustomerResponse(bindingResult.getAllErrors().get(0).getDefaultMessage(),authCustomerDto.emailAddress), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CustomerResponse("User Authenticated.",authCustomerDto.emailAddress),HttpStatus.OK);

    }

    @GetMapping("/forgot")
    public ResponseEntity<CustomerResponse> forgotPassword(@RequestParam String emailId){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailId);
        boolean matchFound = matcher.find();
        if(!matchFound) {
            return new ResponseEntity<>(new CustomerResponse("Please Enter correct Email Address!",emailId), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(new CustomerResponse("Customer Password forgotten.",emailId), HttpStatus.OK);
    }

    @PostMapping("/reset")
    public ResponseEntity<CustomerResponse> resetPassword(@RequestBody @Valid ResetPasswordDto resetPasswordDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(new CustomerResponse(bindingResult.getAllErrors().get(0).getDefaultMessage(),resetPasswordDto.password), HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity<>(new CustomerResponse("Password Updated  Successfully.",""), HttpStatus.OK);

    }

    @GetMapping("/{token}")
    public ResponseEntity<CustomerResponse> getCustomerDetails(@PathVariable String token){
        return new ResponseEntity<>(new CustomerResponse("Getting Customer Details.", token), HttpStatus.OK);
    }

}
