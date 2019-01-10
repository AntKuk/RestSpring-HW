package com.netcracker.service;


import com.netcracker.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerRestService {
    @Autowired
    ICustomerService customerService;

    @GetMapping(value = "/buyer", produces = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.findAllCustomers();
        if(customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
        Customer customer = customerService.findCustomerById(id);

        if(customer == null) {
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }


    /*
    {
        "lastName": "AntonNew",
        "custDistrict": "Autoplane2",
        "discount": 91
    }
     */

    @PostMapping(value = "/buyer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<MyStatus> addCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return new ResponseEntity<MyStatus>(new MyStatus("Added successfuly"), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "buyer", produces = "application/json")
    public ResponseEntity<MyStatus> deleteAllCustomers() {
        int response = customerService.deleteAllCustomers();
        if(response == 0) {
            return new ResponseEntity<MyStatus>(new MyStatus("Table Customer is empty"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyStatus>(new MyStatus("All customers were deleted"), HttpStatus.OK);
    }

    @DeleteMapping(value = "buyer/{id}", produces = "application/json")
    public ResponseEntity<MyStatus> deleteCustomerById(@PathVariable("id") int id) {
        int response = customerService.deleteCustomerById(id);
        if(response == 0) {
            return new ResponseEntity<MyStatus>(new MyStatus("Customer id = " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyStatus>(new MyStatus("Customer id = " + id + " deleted"), HttpStatus.OK);
    }

}
