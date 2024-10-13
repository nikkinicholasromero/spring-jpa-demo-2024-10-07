package com.demo.service;

import com.demo.dto.CreateCustomerRequest;
import com.demo.dto.GetCustomerResponse;
import com.demo.dto.UpdateCustomerRequest;
import com.demo.repository.Customer;
import com.demo.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public GetCustomerResponse getCustomer(String id) {
        return customerRepository.findById(id)
                .map(e -> new GetCustomerResponse(e.id(), e.name()))
                .orElseThrow(EntityNotFoundException::new);
    }

    public GetCustomerResponse createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(
                UUID.randomUUID().toString(),
                request.name());

        customerRepository.save(customer);

        return new GetCustomerResponse(customer.id(), customer.name());
    }

    public GetCustomerResponse updateCustomer(UpdateCustomerRequest request) {
        return customerRepository.findById(request.id())
                .map(e -> {
                    e.updateName(request.name());
                    customerRepository.save(e);
                    return new GetCustomerResponse(e.id(), e.name());
                })
                .orElseThrow(EntityNotFoundException::new);
    }
}
