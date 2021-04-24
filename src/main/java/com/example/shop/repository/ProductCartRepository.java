package com.example.shop.repository;

import com.example.shop.model.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {

//    public ProductCart findByProductId(long id);


}
