package com.uptc.frw.devicesstore.service;

import com.uptc.frw.devicesstore.model.Customer;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface ICustomerService {

    @Transactional(readOnly  = true)
    Customer findCustomerById(int id);

    @Transactional(readOnly = true)
    List<Customer> findAllCustomers();

    @Transactional
    void createCustomer(Customer customer);

    @Transactional
    void deleteCustomer(int id);
}
