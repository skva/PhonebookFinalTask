package com.griddynamics.qa.spring.phonebook.exception;

public class CustomerWithoutPhoneException extends RuntimeException{
    public CustomerWithoutPhoneException(String message) {
        super(message);
    }
}
