package com.spatalabz.choco.userservice.repository;

import com.spatalabz.choco.userservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer,String> {

    boolean findAllByEmailAddress(String emailId);

}
