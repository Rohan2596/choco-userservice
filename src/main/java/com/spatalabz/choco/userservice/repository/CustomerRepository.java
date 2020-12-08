package com.spatalabz.choco.userservice.repository;

import com.spatalabz.choco.userservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer,String> {

    Optional<Customer> findByEmailAddress(String emailId);


}
