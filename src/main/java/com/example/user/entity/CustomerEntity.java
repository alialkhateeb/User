package com.example.user.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CustomerEntity {

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name ="UUID", strategy = "uuid2")
    private Long id;

    @Column()
    private String name;
}
