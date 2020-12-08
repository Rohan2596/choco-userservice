package com.spatalabz.choco.userservice.model;

import com.spatalabz.choco.userservice.dto.AddCustomerDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Customer")
public class Customer implements Serializable {

    @Id
    private String _id;
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


    @Override
    public String toString() {
        return "Customer{" +
                "customer_Id='" + _id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", customerType='" + customerType + '\'' +
                ", createdLocalDateTime=" + createdLocalDateTime +
                ", updatedDateTime=" + updatedDateTime +
                '}';
    }
}
