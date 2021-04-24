package com.example.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orderList;

}
