package com.example.shop.service;

import com.example.shop.model.ShippingAddress;
import com.example.shop.repository.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingAddressService {

        private final ShippingAddressRepository shippingAddressRepository;

        public ShippingAddress addShippingAddress(ShippingAddress shippingAddress) {
            return shippingAddressRepository.save(shippingAddress);
        }
}
