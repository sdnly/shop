package com.example.shop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Data
@Table(name = "customer_order")
public class Order implements Serializable {

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
