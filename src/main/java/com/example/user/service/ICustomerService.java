package com.example.user.service;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;

public interface ICustomerService {

    ResponseInterface createCustomer(Customer customer);

    ResponseInterface getCustomers();

    ResponseInterface getCustomer(String id);

    ResponseInterface updateCustomer(String id, Customer customer);

    ResponseInterface deleteCustomer(String id);
}
