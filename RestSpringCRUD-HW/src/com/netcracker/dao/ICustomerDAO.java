package com.netcracker.dao;

import com.netcracker.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAllCustomers();
    Customer findCustomerById(int id);
    void saveCustomer(Customer entity);
    int deleteAllCustomers();
    int deleteCustomerById(int id);
}
