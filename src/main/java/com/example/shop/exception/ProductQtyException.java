package com.example.shop.exception;

public class ProductQtyException extends RuntimeException {

    public ProductQtyException(int quantity) {
        super("Quantity can't be less or 0" + quantity);
    }
}
