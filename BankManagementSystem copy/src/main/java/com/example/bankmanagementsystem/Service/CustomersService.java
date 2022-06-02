package com.example.bankmanagementsystem.Service;


import com.example.bankmanagementsystem.DTO.BankDTO;
import com.example.bankmanagementsystem.DTO.CustomerDetailsDTO;
import com.example.bankmanagementsystem.Exception.InvalidIDException;
import com.example.bankmanagementsystem.Model.Bank;
import com.example.bankmanagementsystem.Model.CustomerDetails;
import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.Repository.BankRepository;
import com.example.bankmanagementsystem.Repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersService {


    private final CustomersRepository customersRepository;
    private final BankRepository bankRepository;

    public List<Customers> getCustomers(){
        return customersRepository.findAll();
    }

    public void addCustomers(Customers customers) {
        customersRepository.save(customers);
    }

    public Object addCustomerD(CustomerDetailsDTO customerDetailsDTO) {
      Customers customers = customersRepository.findById(customerDetailsDTO.getCustomerId()).get();
        CustomerDetails customerDetails = new CustomerDetails(null, customerDetailsDTO.getAge(), customerDetailsDTO.getBalance(), customers);
        customers.setCustomerDetails(customerDetails);

        customersRepository.save(customers);
        return customersRepository.findAll();
    }


    public Object addBank(BankDTO bankDTO) {
        Customers customers = customersRepository.findById(bankDTO.getCustomerId()).get();
        Bank bank = bankRepository.findById(bankDTO.getBId()).get();
        bank.setCustomers(customers);
        bankRepository.save(bank);
        customers.getBankSet().add(bank);
        customersRepository.save(customers);
        return "Bank added !";
    }

    public Object withdraws(Integer customerId, Integer amount) {
        Customers customers = customersRepository.findById(customerId).
                orElseThrow(()-> new InvalidIDException("Invalid customerId !"));
        if (customers.getCustomerDetails().getBalance() < amount){
           throw new RuntimeException("don't have money");
        }
        customers.getCustomerDetails().setBalance(customers.getCustomerDetails().getBalance() - amount);
        customersRepository.save(customers);
        return "withdraws completed";
    }

    public Object deposits(Integer customerId, Integer amount) {
        Customers customers = customersRepository.findById(customerId).
                orElseThrow(()-> new InvalidIDException("Invalid customerId !"));
        customers.getCustomerDetails().setBalance(customers.getCustomerDetails().getBalance() + amount);
        customersRepository.save(customers);
        return "deposits completed";
    }
}
