package com.example.bankmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer cDId;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private Integer balance;



    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customerId")
    @JsonIgnore
    private Customers customers;
}