package com.example.user.dto;

import com.example.user.dto.response.ResponseInterface;

import java.util.UUID;

public class Customer implements ResponseInterface {

    private UUID id;

    private String name;

    private Address address;

    public Customer(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public Customer(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
