package com.spatalabz.choco.userservice.exception;


public class CustomerException extends  RuntimeException {

    public ExceptionTypes exceptionTypes;

    public enum  ExceptionTypes{
        CUSTOMER_ALREADY_EXIST("Customer already exists!"),
        CUSTOMER_DOESNOT_EXIST("Customer doesnot exists!");

        String message;
         ExceptionTypes(String message) {
            this.message=message;
        }
    }

    public CustomerException( ExceptionTypes exceptionTypes) {
    this.exceptionTypes = exceptionTypes;
    }
}
