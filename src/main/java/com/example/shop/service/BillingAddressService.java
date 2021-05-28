package com.example.shop.service;

import com.example.shop.dto.BillingAddressDto;
import com.example.shop.dto.BillingAddressMapper;
import com.example.shop.model.BillingAddress;
import com.example.shop.repository.BillingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillingAddressService {

        private final BillingAddressRepository billingAddressRepository;
        private final BillingAddressMapper billingAddressMapper;

        public BillingAddressDto addBillingAddress(BillingAddressDto billingAddressDto) {
            var savedBillingAddress = billingAddressRepository.save(billingAddressMapper.toEntity(billingAddressDto));
            return billingAddressMapper.toDto(savedBillingAddress);
        }

        public BillingAddressDto getBillingAddress(long id) {
            var billingAddress = billingAddressRepository.findById(id).orElseThrow();
            return billingAddressMapper.toDto(billingAddress);
        }
}
