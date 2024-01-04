package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.webservices.customerapi.Entity.Customer;
import dev.webservices.customerapi.Service.CustomerService;
import jakarta.persistence.Id;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Save customer data
    @PostMapping("/")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
        System.out.println("Customer data saved!");
    }

    // Find customer using Id
    @GetMapping("/")
    public Customer getCustomer(@RequestParam Long id) {

        // Check if the customer with the given ID exists
        Optional<Customer> customerId = customerService.findById(id);
        if (customerId.isPresent()) {
            return customerService.findById(id).get();
        } else {
            return null;
        }
    }

    // Update customer data
    @PutMapping("/")
    public String update(@RequestBody Customer customer) {

        // Check if the customer with the given ID exists
        Optional<Customer> customerId = customerService.findById(customer.getId());
        if (customerId.isPresent()) {
            customerService.update(customer);
            return "Customer record updated successfully!";
        } else {
            return "Customer not found!";
        }
    }

    // Delete customer data
    @DeleteMapping("/")
    public String delete(Long id) {

        // Check if the customer with the given ID exists
        Optional<Customer> customerId = customerService.findById(id);
        if (customerId.isPresent()) {
            customerService.delete(id);
            return "Customer record deleted successfully!";
        } else {
            return "Customer not found!";
        }
    }
}
