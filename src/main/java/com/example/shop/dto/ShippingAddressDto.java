package com.example.shop.dto;

import lombok.Data;

@Data
public class ShippingAddressDto {

    private long id;
    private String firstName;
    private String lastName;
    private String street;
    private String zipCode;
}

