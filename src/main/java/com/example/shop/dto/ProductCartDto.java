package com.example.shop.dto;

import com.example.shop.model.Order;
import com.example.shop.model.Product;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductCartDto {

    private long id;
    private Order order;
    private List<Product> productList;
    private LocalDateTime createdCart;
}
