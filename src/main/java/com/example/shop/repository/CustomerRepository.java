package com.example.shop.repository;

import com.example.shop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Transactional(readOnly = true)
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


//    Optional<AppUser> findByEmail(String email);
}
