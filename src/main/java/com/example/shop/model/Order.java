package com.example.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private ProductCart productCart;

    @OneToOne(mappedBy = "order")
    private ShippingAddress shippingAddress;

    @OneToOne(mappedBy = "order")
    private BillingAddress billingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
}
