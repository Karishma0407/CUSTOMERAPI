package dev.webservices.customerapi.Service;

import java.util.Optional;

import dev.webservices.customerapi.Entity.Customer;

public interface CustomerService {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

}
