package com.example.bankmanagementsystem.Repository;


import com.example.bankmanagementsystem.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
