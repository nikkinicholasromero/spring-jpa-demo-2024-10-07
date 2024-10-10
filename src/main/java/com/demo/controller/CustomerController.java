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

    @GetMapping("/customer/{id}")
    public GetCustomerResponse getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customer")
    public GetCustomerResponse createCustomer(@RequestBody CreateCustomerRequest request) {
        return customerService.createCustomer(request);
    }

    @PutMapping("/customer")
    public GetCustomerResponse updateCustomer(@RequestBody UpdateCustomerRequest request) {
        return customerService.updateCustomer(request);
    }
}
