package com.example.bankmanagementsystem.Service;


import com.example.bankmanagementsystem.Model.CustomerDetails;
import com.example.bankmanagementsystem.Repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {


    private final CustomerDetailsRepository customerDetailsRepository;


    public List<CustomerDetails> getCustomerD(){
        return customerDetailsRepository.findAll();
    }

    public void addCustomerD(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }
}
