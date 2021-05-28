package com.example.shop.controller;

import com.example.shop.dto.OrderItemDto;
import com.example.shop.dto.ProductCartDto;
import com.example.shop.dto.ProductDto;
import com.example.shop.service.ProductCartService;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ProductCartController {

    private final ProductCartService productCartService;
    private final ProductService productService;


    @PostMapping("/add")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addToCart(@RequestBody ProductDto product) {
        productCartService.addToCart(product);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void removeFromCart(@RequestBody OrderItemDto orderItemDto) {
        productCartService.removeFromCart(orderItemDto);
    }

    @PostMapping("/remove")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void lessFromCart(@RequestBody OrderItemDto orderItemDto) {
        productCartService.lessFromCart(orderItemDto);
    }

    @GetMapping
    public ProductCartDto getProductCart() {
        return productCartService.getProductCarts().get(0);

        //TODO refactoring after logging system implementation
    }
}
