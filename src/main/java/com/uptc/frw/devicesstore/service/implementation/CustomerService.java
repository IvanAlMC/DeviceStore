package com.uptc.frw.devicesstore.service.implementation;

import com.uptc.frw.devicesstore.model.Customer;
import com.uptc.frw.devicesstore.repository.CustomerRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class CustomerService implements com.uptc.frw.devicesstore.service.ICustomerService{


    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public Customer findCustomerById(int id){
        return customerRepository.findById(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }

    @Transactional
    @Override
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }

}
