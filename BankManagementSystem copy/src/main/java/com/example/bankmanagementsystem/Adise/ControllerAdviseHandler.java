package com.example.bankmanagementsystem.Adise;

import com.example.bankmanagementsystem.Exception.BankNotFoundException;
import com.example.bankmanagementsystem.Exception.CustomerDetailsNotFoundException;
import com.example.bankmanagementsystem.Exception.CustomersNotFoundException;
import com.example.bankmanagementsystem.Exception.InvalidIDException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdviseHandler.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNVE){
        logger.warn("MethodArgumentNotValidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNVE.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityVE){
        logger.warn("DataIntegrityViolationException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((dataIntegrityVE.getCause().getMessage()));
    }

    @ExceptionHandler(value = InvalidIDException.class)
    public ResponseEntity handleDataIntegrity(InvalidIDException invalidIDE){
        logger.warn("InvalidIDException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidIDE.getCause().getMessage());
    }

    @ExceptionHandler(value = BankNotFoundException.class)
    public ResponseEntity  handleDataIntegrity(BankNotFoundException bankNotFoundException){
        logger.warn("bankNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bankNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = CustomerDetailsNotFoundException.class)
    public ResponseEntity  handleDataIntegrity(CustomerDetailsNotFoundException customerDetailsNotFoundException){
        logger.warn("bankNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerDetailsNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = CustomersNotFoundException.class)
    public ResponseEntity  handleDataIntegrity(CustomersNotFoundException customersNotFoundException){
        logger.warn("bankNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customersNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        logger.error("Exception");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().getMessage());
    }

}
