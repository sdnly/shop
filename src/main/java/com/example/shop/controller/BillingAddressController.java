package com.example.shop.controller;

import com.example.shop.dto.BillingAddressDto;
import com.example.shop.model.BillingAddress;
import com.example.shop.service.BillingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/billing")
public class BillingAddressController {

        private final BillingAddressService billingAddressService;

        @PostMapping
        public BillingAddressDto addBillingAddress(BillingAddressDto billingAddressDto) {
                return billingAddressService.addBillingAddress(billingAddressDto);
        }

}
