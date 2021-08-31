package com.griddynamics.qa.spring.phonebook.dao;

import com.griddynamics.qa.spring.phonebook.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findCustomerByName(String name);

    public List<Customer> findAllByName(String name);
}
