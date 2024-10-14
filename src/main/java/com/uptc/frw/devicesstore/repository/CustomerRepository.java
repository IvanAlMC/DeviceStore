package com.uptc.frw.devicesstore.repository;

import com.uptc.frw.devicesstore.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
