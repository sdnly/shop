package com.example.shop.service;

import com.example.shop.dto.ProductDto;
import com.example.shop.dto.ProductMapper;
import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    public ProductDto getSingleProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow();

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
        Product editedProduct = productRepository.findById(productDto.getId()).orElseThrow();
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
