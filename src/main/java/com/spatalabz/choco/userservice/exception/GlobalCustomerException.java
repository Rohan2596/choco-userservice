package com.spatalabz.choco.userservice.exception;

import com.spatalabz.choco.userservice.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCustomerException {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<CustomerResponse> handleUserException(CustomerException customerException){
        return new ResponseEntity<>
                (new CustomerResponse(customerException.exceptionTypes.message, customerException.exceptionTypes),
                        HttpStatus.BAD_REQUEST);
    }
}
