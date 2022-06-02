package com.example.bankmanagementsystem.Model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer cId;
    @Column(nullable = false)
    private String name;



    @ManyToOne
    private Customers customers;
}