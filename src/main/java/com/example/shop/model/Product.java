package com.example.shop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int inStock;
    private int price;

    @ManyToOne(cascade = CascadeType.ALL)
    private ProductCart productCart;

}
