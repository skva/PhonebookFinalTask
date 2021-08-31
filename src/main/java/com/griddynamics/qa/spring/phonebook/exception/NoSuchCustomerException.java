package com.griddynamics.qa.spring.phonebook.exception;

public class NoSuchCustomerException extends RuntimeException{

    public NoSuchCustomerException(String message) {
        super(message);
    }
}
