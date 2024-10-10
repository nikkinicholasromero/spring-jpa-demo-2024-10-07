package com.demo.controller;

import com.demo.dto.CreateCustomerRequest;
import com.demo.dto.GetCustomerResponse;
import com.demo.dto.UpdateCustomerRequest;
import com.demo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<GetCustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    @PutMapping("/customer")
    public void updateCustomer(@RequestBody UpdateCustomerRequest request) {
        customerService.updateCustomer(request);
    }
}
