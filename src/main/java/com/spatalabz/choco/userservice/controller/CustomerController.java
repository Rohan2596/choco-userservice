package com.spatalabz.choco.userservice.controller;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/choco/customer/user")
public class CustomerController {

    @PostMapping
    public String addCustomer(@RequestBody @Valid AddCustomerDto addCustomerDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "User Added.";
    }

    @PostMapping("/auth")
    public String authenticatingCustomer(@RequestBody @Valid AuthCustomerDto authCustomerDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "User Authenticated.";
    }
}
