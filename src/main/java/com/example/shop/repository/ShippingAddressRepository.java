package com.example.shop.repository;

import com.example.shop.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
