package com.example.user.service.implmentation;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;
import com.example.user.service.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Override
    public ResponseInterface createCustomer(Customer customer) {


        return null;
    }

    @Override
    public ResponseInterface getCustomers() {
        return null;
    }

    @Override
    public ResponseInterface getCustomer(String id) {
        return null;
    }

    @Override
    public ResponseInterface updateCustomer(String id, Customer customer) {
        return null;
    }

    @Override
    public ResponseInterface deleteCustomer(String id) {
        return null;
    }
}
