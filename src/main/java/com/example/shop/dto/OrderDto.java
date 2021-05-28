package com.example.shop.dto;

import com.example.shop.model.BillingAddress;
import com.example.shop.model.OrderItem;
import com.example.shop.model.ShippingAddress;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private long id;
    private List<OrderItem> orderItemList;
    private ShippingAddress shippingAddress;
    private BillingAddress billingAddress;
    private LocalDateTime createdAt;
}
