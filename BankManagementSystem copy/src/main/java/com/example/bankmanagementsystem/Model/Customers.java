package com.example.bankmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Integer cId;
    @Column(nullable = false)
    private String username;



    @OneToOne(mappedBy = "customers", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Bank> bankSet;
}