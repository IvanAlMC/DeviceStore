package com.uptc.frw.devicesstore.controller;

import com.uptc.frw.devicesstore.graphql.InputCustomer;
import com.uptc.frw.devicesstore.model.Customer;
import com.uptc.frw.devicesstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCustomerController {

    @Autowired
    private ICustomerService customerService;

    @QueryMapping(name ="findCustomerById")
    public Customer findCustomerById(@Argument(name = "customerId") String customerId) {
        int customerIdInt = Integer.parseInt(customerId);
        return customerService.findCustomerById(customerIdInt);
    }

    @QueryMapping(name = "findAllCustomers")
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @MutationMapping(name="createCustomer")
    public Customer createCustomer(@Argument(name = "inputCustomer") InputCustomer inputCustomer) {
        Customer customer = new Customer();
        customer.setNameCustomer(inputCustomer.getNameCustomer());
        customer.setCodeDocument(inputCustomer.getCodeDocument());
        customer.setEmail(inputCustomer.getEmail());
        customer.setPhone(inputCustomer.getPhone());
        customer.setAddress(inputCustomer.getAddress());

        customerService.createCustomer(customer);
        return customer;
    }

    @MutationMapping(name="deleteCustomerById")
    public String deleteCustomerById(@Argument(name = "customerId") String customerId) {

        if (customerId == null || customerId.isBlank()) {
            return "Customer ID is required.";
        }

        int customerIdInt = Integer.parseInt(customerId);
        customerService.deleteCustomer(customerIdInt);
        return "The customer with ID " + customerIdInt + " was deleted.";
    }

    @MutationMapping(name = "updateCustomer")
    public Customer updateCustomer(@Argument(name ="customerId")String customerId, @Argument(name = "inputCustomer") InputCustomer inputCustomer) {
        if (customerId == null || customerId.isBlank()) {
            return null;

        }
        int customeridInt = Integer.parseInt(customerId);

        Customer customer = customerService.findCustomerById(customeridInt);
        if (customer == null) {
            return null;
        }
        customer.setNameCustomer(inputCustomer.getNameCustomer());
        customer.setCodeDocument(inputCustomer.getCodeDocument());
        customer.setEmail(inputCustomer.getEmail());
        customer.setPhone(inputCustomer.getPhone());
        customer.setAddress(inputCustomer.getAddress());
        customerService.createCustomer(customer);
        return customer;
    }

}
