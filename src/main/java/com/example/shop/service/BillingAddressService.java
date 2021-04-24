package com.example.shop.service;

import com.example.shop.model.BillingAddress;
import com.example.shop.repository.BillingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BillingAddressService {

        private final BillingAddressRepository billingAddressRepository;

        public BillingAddress addBillingAddress(BillingAddress billingAddress) {
            return billingAddressRepository.save(billingAddress);
        }

        public BillingAddress getBillingAddress(long id) {
            return billingAddressRepository.findById(id).orElseThrow();
        }
}
