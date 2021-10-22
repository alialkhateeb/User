package com.example.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name ="UUID", strategy = "uuid2")
    private UUID id;

    @Column()
    private String name;

    @OneToOne(cascade = {CascadeType.ALL} )
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressEntity address;

    public CustomerEntity(String name) {
        this.name = name;
    }

    public CustomerEntity(String name, AddressEntity address) {
        this.name = name;
        this.address = address;
    }

    public CustomerEntity() {
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

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }
}
