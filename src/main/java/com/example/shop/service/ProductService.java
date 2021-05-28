package com.example.shop.service;

import com.example.shop.dto.ProductDto;
import com.example.shop.dto.ProductMapper;
import com.example.shop.exception.ProductNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.notification.EmailMessage;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final EmailMessage emailMessage;

    public void subscribe(long id) {
        Product product = productRepository.findById(id).orElseThrow();
        EmailMessage emailMessage = new EmailMessage();
        product.registerObserver(emailMessage);
        log.info("notyfikacja on");
        product.notifyObservers();

    }

    public List<ProductDto> sortedProductsByInStock() {
        List<Product> all = productRepository.findAll();
        List<Product> collect = all.stream()
                .sorted(Comparator.comparing(Product::getInStock))
                .collect(Collectors.toList());
        return productMapper.toDtos(collect);
    }

    public List<ProductDto> sortedProductsByPrice() {
        List<Product> all = productRepository.findAll();
        List<Product> collect = all.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
        return productMapper.toDtos(collect);
    }

    public ProductDto getSingleProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        return productMapper.toDto(product);
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product savedProduct = productRepository.save(productMapper.toEntity(productDto));
        return productMapper.toDto(savedProduct);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return productMapper.toDtos(all);
    }

    @Transactional
    public ProductDto editProduct(ProductDto productDto) {
        Product editedProduct = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductNotFoundException(productDto.getId()));
        editedProduct.setDescription(productDto.getDescription());
        editedProduct.setPrice(productDto.getPrice());
        editedProduct.setInStock(productDto.getInStock());
        editedProduct.setName(productDto.getName());

        return productMapper.toDto(editedProduct);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }


}
