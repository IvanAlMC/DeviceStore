package com.uptc.frw.devicesstore.model;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "CUSTOMER_NAME")
    private String nameCustomer;
    @Column(name = "CUSTOMER_CODE_DOCU")
    private String codeDocument;
    @Column(name = "CUSTOMER_DIRECTION")
    private String address;
    @Column(name = "CUSTOMER_PHONE")
    private String phone;
    @Column(name = "CUSTOMER_EMAIL")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Repair> repairs;
}
