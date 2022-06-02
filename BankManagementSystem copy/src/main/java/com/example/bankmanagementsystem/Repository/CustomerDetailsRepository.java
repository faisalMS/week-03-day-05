package com.example.bankmanagementsystem.Repository;


import com.example.bankmanagementsystem.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {
}
