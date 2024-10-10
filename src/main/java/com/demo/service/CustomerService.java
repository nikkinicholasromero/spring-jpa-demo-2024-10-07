package com.demo.service;

import com.demo.dto.CreateCustomerRequest;
import com.demo.dto.GetCustomerResponse;
import com.demo.repository.Customer;
import com.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<GetCustomerResponse> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(e -> new GetCustomerResponse(e.id(), e.name()))
                .toList();
    }

    public void createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(
                UUID.randomUUID().toString(),
                request.name());

        customerRepository.save(customer);
    }
}
