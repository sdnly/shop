package com.example.shop.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(long id) {
        super("Product doesn't exist: " + id);
    }
}
