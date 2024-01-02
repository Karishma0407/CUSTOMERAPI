package dev.webservices.customerapi.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.customerapi.Entity.Customer;
import dev.webservices.customerapi.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CityService cityService;

    @Override
    public Customer save(Customer customer) {
        if (customer.getAddresses() != null) {
            customer.getAddresses().forEach(customerAddress -> {
                customerAddress.setCity(cityService.save(customerAddress.getCity()));
            });
        }
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        Optional<Customer> customerId = customerRepository.findById(customer.getId());
        if (customerId.isPresent()) {
            customerRepository.save(customer);
        }
    }

    @Override
    public void delete(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        }
    }

}
