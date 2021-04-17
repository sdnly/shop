package com.example.shop.dto;

import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String description;
    private int inStock;
    private int price;
}
