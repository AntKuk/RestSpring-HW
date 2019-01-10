package com.netcracker.service;

import com.netcracker.dao.ICustomerDAO;
import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerDAO customerDAO;


    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }

    public Customer findCustomerById(int id) {
        return customerDAO.findCustomerById(id);
    }

    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    public int deleteAllCustomers() {
        return customerDAO.deleteAllCustomers();
    }

    public int deleteCustomerById(int id) {
        return customerDAO.deleteCustomerById(id);
    }
}
