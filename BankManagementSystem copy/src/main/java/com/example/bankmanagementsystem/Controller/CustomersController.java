package com.example.bankmanagementsystem.Controller;


import com.example.bankmanagementsystem.DTO.Api;
import com.example.bankmanagementsystem.DTO.BankDTO;
import com.example.bankmanagementsystem.DTO.CustomerDetailsDTO;
import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.Service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomersController {
    private final CustomersService customersService;
    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);


    @GetMapping
    public ResponseEntity<List<Customers>> getCustomers() {
        logger.info("getCustomers");

        return ResponseEntity.status(HttpStatus.OK).body(customersService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<Api> addCustomers(@RequestBody Customers customers) {
        logger.info("addCustomers");

        customersService.addCustomers(customers);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Customers added !", 200));
    }

    @PostMapping("/details")
    public ResponseEntity addCustomerD(@RequestBody CustomerDetailsDTO customerDetailsDTO) {
        logger.info("addCustomers");
        customersService.addCustomerD(customerDetailsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(customersService.addCustomerD(customerDetailsDTO));
    }

    @PostMapping("/bank")
    public ResponseEntity addBank(@RequestBody BankDTO bankDTO) {
        logger.info("addBank");

        customersService.addBank(bankDTO);
        return ResponseEntity.status(HttpStatus.OK).body(customersService.addBank(bankDTO));
    }

    @PutMapping("/withdraws/{customerId}/{amount}")
    public ResponseEntity withdraws(@PathVariable Integer customerId,@PathVariable Integer amount){
        logger.info("withdraws");


        return ResponseEntity.status(HttpStatus.OK).body(customersService.withdraws(customerId, amount));
    }

    @PutMapping("/deposits/{customerId}/{amount}")
    public ResponseEntity deposits(@PathVariable Integer customerId, @PathVariable Integer amount){
        logger.info("deposits");


        return ResponseEntity.status(HttpStatus.OK).body(customersService.deposits(customerId, amount));
    }
}
