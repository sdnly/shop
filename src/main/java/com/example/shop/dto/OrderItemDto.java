package com.example.shop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private long id;
    private String name;
    private String imgUrl;
    private String description;
    private int quantity;
    private BigDecimal price;
}
