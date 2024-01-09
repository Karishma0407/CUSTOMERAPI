package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.webservices.customerapi.Entity.Customer;
import dev.webservices.customerapi.Service.CustomerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Save customer data
    @PostMapping("/")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.save(customer);
        return savedCustomer != null
                ? new ResponseEntity<>(savedCustomer, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Find customer using Id
    @GetMapping("/")
    public ResponseEntity<Customer> getCustomer(@RequestParam Long id) {

        // Check if the customer with the given ID exists
        Optional<Customer> customerId = customerService.findById(id);

        // do we have a customer?
        return customerId.map(
                // if yes: send it, with a success code
                value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))

                // otherwise: send it an error code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete customer data
    @DeleteMapping("/")
    public ResponseEntity<Customer> delete(Long id) {

        // Check if the customer with the given ID exists
        Optional<Customer> customerId = customerService.findById(id);
        if (customerId.isPresent()) {
            customerService.delete(id);
            return new ResponseEntity<>(customerId.get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
