package com.example.bankmanagementsystem.Exception;

public class CustomerDetailsNotFoundException extends RuntimeException{

    public CustomerDetailsNotFoundException(String message){
        super(message);
    }
}
