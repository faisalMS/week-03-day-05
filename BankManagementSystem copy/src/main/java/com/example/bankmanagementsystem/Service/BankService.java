package com.example.bankmanagementsystem.Service;


import com.example.bankmanagementsystem.Model.Bank;
import com.example.bankmanagementsystem.Repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {


    private final BankRepository bankRepository;


    public List<Bank> getBank(){
        return bankRepository.findAll();
    }

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }
}
