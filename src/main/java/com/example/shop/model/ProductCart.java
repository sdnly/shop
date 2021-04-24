package com.example.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Order order;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();

    private int qty;

    private int total;

    private LocalDateTime createdCart;


    public ProductCart(List<Product> productList, LocalDateTime createdCart) {

    }
}
