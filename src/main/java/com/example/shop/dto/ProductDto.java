package com.example.shop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String imgUrl;
    private String description;
    private int inStock;
    private BigDecimal price;
}
