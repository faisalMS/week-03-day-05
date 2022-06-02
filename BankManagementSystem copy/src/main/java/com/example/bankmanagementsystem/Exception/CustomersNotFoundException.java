package com.example.bankmanagementsystem.Exception;

public class CustomersNotFoundException extends RuntimeException{

    public CustomersNotFoundException (String message){
        super(message);
    }
}
