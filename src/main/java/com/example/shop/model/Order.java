package com.example.shop.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@ToString
@Data
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

    @OneToOne(mappedBy = "order")
    private ShippingAddress shippingAddress;

    @OneToOne(mappedBy = "order")
    private BillingAddress billingAddress;

    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private LocalDateTime createdAt;
}
