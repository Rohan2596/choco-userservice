package com.spatalabz.choco.userservice.model;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collation = "customer")
public class Customer {

    @org.springframework.data.annotation.Id
    private String Id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private String customerType;
    private LocalDateTime createdLocalDateTime=LocalDateTime.now();
    private LocalDateTime updatedDateTime;

    public Customer(AddCustomerDto addCustomerDto) {
        this.firstName=addCustomerDto.firstName;
        this.lastName=addCustomerDto.lastName;
        this.emailAddress=addCustomerDto.emailAddress;
        this.password=addCustomerDto.password;
        this.customerType=addCustomerDto.customerType;
        this.updatedDateTime=LocalDateTime.now();
    }
}
