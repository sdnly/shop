package com.example.shop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String street;
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "customer_order_id")
    private Order order;
}
