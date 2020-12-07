package com.spatalabz.choco.userservice.service;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import com.spatalabz.choco.userservice.dto.AuthCustomerDto;
import com.spatalabz.choco.userservice.dto.ResetPasswordDto;

public interface CustomerService {

    String addingCustomer(AddCustomerDto addCustomerDto);
    String authenticationCustomer(AuthCustomerDto authCustomerDto);
    String passwordForgotten(String emailId);
    String resetPassword(ResetPasswordDto resetPasswordDto);
    String customerDetails(String token);
}
