package com.example.user.controller;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;
import com.example.user.service.ICustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public ResponseInterface createCustomer(@RequestBody Customer customer) {
        return this.customerService.createCustomer(customer);
    }

    @GetMapping()
    public List<ResponseInterface> getCustomers() {
        return this.customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public ResponseInterface getCustomer(@PathVariable("id") UUID id) {
        return this.customerService.getCustomer(id);
    }

    @PutMapping("/{id}")
    public ResponseInterface updateCustomer(@PathVariable("id") UUID id, @RequestBody Customer customer) {
        return this.customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseInterface deleteCustomer(@PathVariable("id") UUID id) {
        return this.customerService.deleteCustomer(id);
    }
}
