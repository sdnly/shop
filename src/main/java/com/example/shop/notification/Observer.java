package com.example.shop.notification;

import com.example.shop.dto.ProductDto;
import com.example.shop.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface Observer {

    void update(Product product);
}
