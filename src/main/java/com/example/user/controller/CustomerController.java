package com.example.user.controller;

import com.example.user.dto.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @PostMapping()
    public void createCustomer(@RequestBody Customer customer) {

    }

    @GetMapping()
    public void getCustomers() {

    }

    @GetMapping("/{id}")
    public void getCustomer(@PathVariable("id") String id) {

    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {

    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String id) {


    }
}
