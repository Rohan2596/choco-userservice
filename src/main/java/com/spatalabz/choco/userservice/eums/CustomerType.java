package com.spatalabz.choco.userservice.eums;

public enum CustomerType {

    RESTARAUNT("Customer Type is restaraunts"),
    SUPPLIER("Customer Type is suppliers");

    String message;
    CustomerType(String message) {
        this.message=message;
    }
}
