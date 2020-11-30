package com.spatalabz.choco.userservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choco/customer/user")
public class CustomerController {

    @PostMapping
    public String addCustomer() {
        return "User Added.";
    }
}
