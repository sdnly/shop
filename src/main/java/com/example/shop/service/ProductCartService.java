package com.example.shop.service;

import com.example.shop.dto.ProductCartMapper;
import com.example.shop.exception.ProductQtyException;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCart;
import com.example.shop.repository.ProductCartRepository;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductCartRepository productCartRepository;
    private final ProductCartMapper productCartMapper;
    private final ProductRepository productRepository;

    @Transactional
    public void addToCart(long id, int quantity) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductCart productCart = new ProductCart();
        productCart.setCreatedCart(LocalDateTime.now());
        product.setInStock(product.getInStock() - quantity);
        productCart.setQty(quantity);
        productCart.setTotal(product.getPrice() * quantity);
        List<Product> productList = productCart.getProductList();
        productList.add(product);
        productCartRepository.save(productCart);
    }

    @Transactional
    public void removeFromCart(long id, long productId, int quantity) {
        if (quantity <= 0) {
            throw new ProductQtyException("Invalid quantity");
        }

        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
        Product product1 = productRepository.findById(productId).orElseThrow();

        List<Product> productList = productCart.getProductList();
        productList
                .forEach(product -> product.setInStock(product.getInStock() + quantity));

        productCart.setTotal(productCart.getTotal() - quantity * product1.getPrice());
        productCart.setQty(productCart.getQty() - quantity);
    }

    public ProductCart prepareCart(List<Product> list) {
        return new ProductCart(list, LocalDateTime.now());
    }

    public List<ProductCart> getListItems() {
        return productCartRepository.findAll();
    }

    public ProductCart getSingleProductCart(long id) {
        return productCartRepository.findById(id).orElseThrow();
    }

    public ProductCart addProductCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    public boolean checkIfExists(ProductCart productCart) {
        return productCartRepository.existsById(productCart.getId());
    }
}
