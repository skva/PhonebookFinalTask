package com.griddynamics.qa.spring.phonebook.service;

import com.griddynamics.qa.spring.phonebook.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getAllCustomers();

    public Customer getCustomerByName(String name);

    public String getPhoneByName(String name);

    public Customer addPhone(String name, String phone);

    public void saveCustomer(Customer customer);

    public void deleteCustomerByName(String name);


    //Additional methods for practice
    public Customer getCustomer(int id);

    public List<Customer> findAllByName(String name);

    public void deleteCustomer(int id);
}
