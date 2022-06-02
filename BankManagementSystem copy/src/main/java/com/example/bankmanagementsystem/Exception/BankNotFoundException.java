package com.example.bankmanagementsystem.Exception;

public class BankNotFoundException extends RuntimeException{

    public BankNotFoundException(String message){
        super(message);
    }
}
