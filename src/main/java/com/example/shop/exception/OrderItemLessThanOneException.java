package com.example.shop.exception;

public class OrderItemLessThanOneException extends RuntimeException{

    public OrderItemLessThanOneException() {
        super("You can't have less than one pieces of an item in cart");
    }
}
