package com.example.shop.repository;

import com.example.shop.model.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
