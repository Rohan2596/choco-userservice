package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;
import com.spatalabz.choco.userservice.exception.CustomerException;
import com.spatalabz.choco.userservice.model.Customer;

public interface CustomerService {

    String addingCustomer(AddCustomerDto addCustomerDto);
    String authenticationCustomer(AuthCustomerDto authCustomerDto) throws CustomerException;
    String passwordForgotten(String emailId);
    String resetPassword(ResetPasswordDto resetPasswordDto,String token);
    Customer customerDetails(String token);
}
