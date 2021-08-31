package com.griddynamics.qa.spring.phonebook.service;

import com.griddynamics.qa.spring.phonebook.dao.CustomerRepository;
import com.griddynamics.qa.spring.phonebook.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        return customer;
    }

    @Override
    public String getPhoneByName(String name) {
        Customer customer = customerRepository.findCustomerByName(name);
        return customer.getPhone();
    }

    @Override
    public Customer addPhone(String name, String phone) {
        Customer customer = customerRepository.findCustomerByName(name);
        customer.setPhone(customer.getPhone() + " | +" + phone);
        return customer;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerByName(String name) {
        customerRepository.delete(customerRepository.findCustomerByName(name));
    }


    //Additional methods for practice
    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        Optional<Customer> optional = customerRepository.findById(id);
        if(optional.isPresent()) {
            customer = optional.get();
        }
        return customer;
    }

    @Override
    public List<Customer> findAllByName(String name) {
        List<Customer> customers = customerRepository.findAllByName(name);
        return customers;
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
