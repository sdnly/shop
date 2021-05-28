package com.example.shop.service;

import com.example.shop.dto.ShippingAddressDto;
import com.example.shop.dto.ShippingAddressMapper;
import com.example.shop.model.ShippingAddress;
import com.example.shop.repository.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShippingAddressService {

        private final ShippingAddressRepository shippingAddressRepository;
        private final ShippingAddressMapper shippingAddressMapper;


        public ShippingAddressDto addShippingAddress(ShippingAddressDto shippingAddressDto) {
            ShippingAddress save = shippingAddressRepository.save(shippingAddressMapper.toEntity(shippingAddressDto));
            return shippingAddressMapper.toDto(save);
        }
}
