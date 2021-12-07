package com.sarin.cms.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message){
        super(message);
    }
}
