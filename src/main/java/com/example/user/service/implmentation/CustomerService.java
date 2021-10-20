package com.example.user.service.implmentation;

import com.example.user.dto.Customer;
import com.example.user.dto.response.ResponseInterface;
import com.example.user.entity.CustomerEntity;
import com.example.user.exception.ApiRequestException;
import com.example.user.repository.CustomerRepository;
import com.example.user.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public ResponseInterface getCustomer(UUID id) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if (entity.isEmpty()){
            throw new ApiRequestException("no customer were found");
        }
        return new Customer(entity.get().getId(), entity.get().getName());
    }

    @Override
    public ResponseInterface updateCustomer(UUID id, Customer customer) {
        System.out.println("test");
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if (entity.isEmpty()){
            throw new ApiRequestException("no customer were found");

        }
        entity.get().setName(customer.getName());
        this.customerRepository.save(entity.get());
        return new Customer(entity.get().getId(), entity.get().getName());
    }

    @Override
    public void deleteCustomer(UUID id) {
        Optional<CustomerEntity> entity = this.customerRepository.findById(id);
        if(entity.isEmpty()){
            throw new ApiRequestException("no customer were found");
        }

        //TODO: return error object with 400 (not found)
        this.customerRepository.deleteById(id);

    }
}
