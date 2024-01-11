package dev.webservices.customerapi.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.customerslib.Entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
