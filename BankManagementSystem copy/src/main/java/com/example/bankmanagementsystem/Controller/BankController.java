package com.example.bankmanagementsystem.Controller;


import com.example.bankmanagementsystem.DTO.Api;
import com.example.bankmanagementsystem.Model.Bank;
import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.Service.BankService;
import com.example.bankmanagementsystem.Service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {
    private final BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);

    @GetMapping
    public ResponseEntity<List<Bank>> getBank(){
        logger.info("getBank");
        return ResponseEntity.status(HttpStatus.OK).body(bankService.getBank());
    }

    @PostMapping
    public ResponseEntity<Api> addBank(@RequestBody @Valid Bank bank){
        logger.info("addBank");
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Bank added !", 200));
    }
}
