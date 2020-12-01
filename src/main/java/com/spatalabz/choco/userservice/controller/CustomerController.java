package com.spatalabz.choco.userservice.controller;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @GetMapping("/forgot")
    public String forgotPassword(@RequestParam String emailId){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.-]+@[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+[a-zA-Z0-9.-]*+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(emailId);
        boolean matchFound = matcher.find();
        if(!matchFound) {
            return "Please Enter correct Email Address!";
        }
        return "Customer Password forgotten.";
    }

    @PostMapping("/reset")
    public String resetPassword(@RequestBody @Valid ResetPasswordDto resetPasswordDto,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }
        return "Password Updated  Successfully.";
    }
}
