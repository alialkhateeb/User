package com.example.user.service;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;

import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    ResponseInterface createCustomer(Customer customer);

    List<ResponseInterface> getCustomers();

    ResponseInterface getCustomer(UUID id);

    ResponseInterface updateCustomer(UUID id, Customer customer);

    void deleteCustomer(UUID id);
}
