package com.example.shop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
}
