package com.demo.controller;

import com.demo.dto.CreateCustomerRequest;
import com.demo.dto.GetCustomerResponse;
import com.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<GetCustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }
}
