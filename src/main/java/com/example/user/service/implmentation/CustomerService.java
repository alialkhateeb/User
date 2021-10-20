package com.example.user.service.implmentation;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;
import com.example.user.entity.CustomerEntity;
import com.example.user.repository.CustomerRepository;
import com.example.user.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseInterface createCustomer(Customer customer) {
        CustomerEntity customerEn = new CustomerEntity(customer.getName());
        this.customerRepository.save(customerEn);
        customer.setId(customerEn.getId());
        return customer;
    }

    @Override
    public List<ResponseInterface> getCustomers() {
        return this.customerRepository.findAll().stream().map(value -> new Customer(value.getId(), value.getName())).collect(Collectors.toList());
    }

    @Override
    public ResponseInterface getCustomer(Long id) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if (entity.isPresent()){
            return new Customer(entity.get().getId(), entity.get().getName());
        }
        return null;
    }

    @Override
    public ResponseInterface updateCustomer(Long id, Customer customer) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if (entity.isPresent()){
            entity.get().setName(customer.getName());
            entity.get().setId(customer.getId());
            this.customerRepository.save(entity.get());
            return new Customer(entity.get().getId(), entity.get().getName());
        }

        return null;
    }

    @Override
    public ResponseInterface deleteCustomer(Long id) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if(entity.isPresent()){
            this.customerRepository.deleteById(id);
        }
        return null;
    }
}
