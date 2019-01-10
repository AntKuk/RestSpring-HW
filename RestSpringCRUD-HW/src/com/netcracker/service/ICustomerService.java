package com.netcracker.service;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void saveCustomer(Customer entity);
    int deleteAllCustomers();
    int deleteCustomerById(int id);
}
