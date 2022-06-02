package com.example.bankmanagementsystem.Controller;


import com.example.bankmanagementsystem.DTO.Api;
import com.example.bankmanagementsystem.Model.CustomerDetails;
import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.Service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customerDetails")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;
    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerD() {
        logger.info("getCustomerD");

        return ResponseEntity.status(HttpStatus.OK).body(customerDetailsService.getCustomerD());
    }

    @PostMapping
    public ResponseEntity<Api> addCustomerD(@RequestBody @Valid CustomerDetails customerDetails) {
        logger.info("addCustomerD");
        customerDetailsService.addCustomerD(customerDetails);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("CustomerDetails added !", 200));
    }
}
