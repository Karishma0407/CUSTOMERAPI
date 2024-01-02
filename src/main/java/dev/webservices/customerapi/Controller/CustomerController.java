package dev.webservices.customerapi.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dev.webservices.customerapi.Entity.Customer;
import dev.webservices.customerapi.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // save customer data
    @PostMapping("/")
    public void save(@RequestBody Customer customer) {
        customerService.save(customer);
        System.out.println("Customer data saved!");
    }

    // Find customer using Id
    @GetMapping("/")
    public Customer getCustomer(@RequestParam Long id) {
        return customerService.findById(id).get();
    }

    // Update customer data
    @PutMapping("/")
    public String update(@RequestBody Customer customer) {
        Optional<Customer> customerId = customerService.findById(customer.getId());

        // Check if the customer with the given ID exists
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
        customerService.delete(id);
        return "Customer record deleted successfully!";
    }
}
