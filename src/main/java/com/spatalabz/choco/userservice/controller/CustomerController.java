package com.spatalabz.choco.userservice.controller;

import com.spatalabz.choco.userservice.dto.AddCustomer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choco/customer/user")
public class CustomerController {

    @PostMapping
    public String addCustomer(@RequestBody AddCustomer addCustomer) {
        System.out.println(addCustomer.toString());
        return "User Added.";
    }
}
