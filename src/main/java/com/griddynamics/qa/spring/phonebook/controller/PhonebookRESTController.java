package com.griddynamics.qa.spring.phonebook.controller;

import com.griddynamics.qa.spring.phonebook.entity.Customer;
import com.griddynamics.qa.spring.phonebook.exception.CustomerWithoutPhoneException;
import com.griddynamics.qa.spring.phonebook.exception.NoSuchCustomerException;
import com.griddynamics.qa.spring.phonebook.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PhonebookRESTController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Customer> showAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping("/customers/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public String getPhoneByName(@PathVariable String name) {
        Customer customer = customerService.getCustomerByName(name);
        return customer.getPhone();
    }

    @PutMapping("/customers/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer addPhone(@PathVariable String name,
                             @RequestParam String phone) {
        Customer customer = customerService.addPhone(name, phone);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PostMapping("/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer addNewCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteCustomerByName(@PathVariable String name) {
        Customer customer = customerService.getCustomerByName(name);
        if(customer.getPhone()==null) {
            throw new CustomerWithoutPhoneException("Unable to delete customer " + name + " without phone");
        }
        customerService.deleteCustomerByName(name);
        return "Customer with ID = " + name + " was deleted";
    }


    //Additional methods for practice
    @GetMapping("/customers/name/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer getCustomerByName(@PathVariable String name) {
        Customer customer = customerService.getCustomerByName(name);
        if(customer==null) {
            throw new NoSuchCustomerException("There is no customer with name: " +
                    name + " in Database");
        }
        return customer;
    }

    @GetMapping("/customers/all/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Customer> showAllCustomersByName(@PathVariable String name) {
        List<Customer> customers = customerService.findAllByName(name);
        return customers;
    }

    @GetMapping("/customers/id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer getCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if(customer ==null) {
            throw new NoSuchCustomerException("There is no customer with ID = " +
                    id + " in Database");
        }
        return customer;
    }

    @PutMapping("/customers")
    @ResponseStatus(code = HttpStatus.OK)
    public Customer updateCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/id/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String deleteCustomer(@PathVariable int id) {
        Customer customer = customerService.getCustomer(id);
        if(customer==null) {
            throw new NoSuchCustomerException("There is no customer with ID = " +
                    id + " in Database");
        }
        customerService.deleteCustomer(id);
        return "Customer with ID = " + id + " was deleted";
    }
}
