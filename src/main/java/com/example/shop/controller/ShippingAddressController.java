package com.example.shop.controller;

import com.example.shop.dto.ShippingAddressDto;
import com.example.shop.model.ShippingAddress;
import com.example.shop.service.ShippingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipping")
public class ShippingAddressController {

        private final ShippingAddressService shippingAddressService;


        @PostMapping
        public ShippingAddressDto addShippingAddress(@RequestBody ShippingAddressDto shippingAddressDto) {
            return shippingAddressService.addShippingAddress(shippingAddressDto);
        }
}
