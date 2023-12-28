package dev.webservices.customerapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.customerapi.Entity.Customer;
import dev.webservices.customerapi.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // save customer data
    @PostMapping("/save")
    public void save(@RequestBody Customer customer) {

        customerService.save(customer);

        System.out.println("Customer data saved!");
    }
}
