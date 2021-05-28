package com.example.shop.service;

import com.example.shop.dto.*;
import com.example.shop.exception.OrderItemLessThanOneException;
import com.example.shop.exception.ProductNotFoundException;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCart;
import com.example.shop.repository.OrderItemRepository;
import com.example.shop.repository.ProductCartRepository;
import com.example.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductCartRepository productCartRepository;
    private final ProductCartMapper productCartMapper;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderItemMapper orderItemMapper;

    private final OrderItemDto orderItemDto = new OrderItemDto();

//    @Transactional
//    public void addToCart(long id, int quantity) {
//        Product product = productRepository.findById(id).orElseThrow();
//        product.setInStock(product.getInStock() - quantity);
//        productCart.setQty(quantity);
//        productCart.setTotal(product.getPrice() * quantity);
//        List<Product> productList = productCart.getProductList();
//        productList.add(product);
//        productCartRepository.save(productCart);
//    }

//    @Transactional
//    public void addToCart(Product product) {
//        productRepository.findById(product.getId()).orElseThrow();
//        productCart.setTotal(product.getPrice());
//        List<Product> productList = productCart.getProductList();
//        productList.add(product);
//        productCartRepository.save(productCart);
//    }


    public void addToCart(ProductDto productDto) {
        try {
            Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductNotFoundException(productDto.getId()));
            var orderItem = orderItemRepository.findById(productDto.getId()).orElseThrow(() -> new ProductNotFoundException(orderItemDto.getId()));

            if (orderItemRepository.existsById(orderItem.getId()) == productRepository.existsById(product.getId())) {
                orderItem.setQuantity(orderItem.getQuantity() + 1);
                orderItemRepository.save(orderItem);
            }

        } catch (ProductNotFoundException e) {
            Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductNotFoundException(productDto.getId()));

            orderItemDto.setId(product.getId());
            orderItemDto.setName(product.getName());
            orderItemDto.setDescription(product.getDescription());
            orderItemDto.setPrice(product.getPrice());
            orderItemDto.setQuantity(orderItemDto.getQuantity() + 1);
            orderItemRepository.save(orderItemMapper.toEntity(orderItemDto));
        }
    }

    public void orderItemChecker(OrderItemDto orderItemDto, ProductDto productDto) {
        var orderItem = orderItemRepository.findById(orderItemDto.getId()).orElseThrow(() -> new ProductNotFoundException(orderItemDto.getId()));
        var product = productRepository.findById(productDto.getId()).orElseThrow(() -> new ProductNotFoundException(productDto.getId()));

        if (orderItem.getId() == product.getId()) {
            orderItem.setQuantity(orderItem.getQuantity() + 1);
        }
    }

//
//    @Transactional
//    public void removeFromCart(long id, long productId, int quantity) {
//        if (quantity <= 0) {
//            throw new ProductQtyException(quantity);
//        }
//
//        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
//        Product product1 = productRepository.findById(productId).orElseThrow();
//
//        List<Product> productList = productCart.getProductList();
//        productList
//                .forEach(product -> product.setInStock(product.getInStock() + quantity));
//
//        productCart.setTotal(productCart.getTotal() - quantity * product1.getPrice());
//        productCart.setQty(productCart.getQty() - quantity);
//    }

    @Transactional
    public void removeFromCart(OrderItemDto orderItemDto) {
        orderItemRepository.deleteById(orderItemDto.getId());
    }

    @Transactional
    public void lessFromCart(OrderItemDto orderItemDto) {
        var orderItem = orderItemRepository.findById(orderItemDto.getId()).orElseThrow(() -> new RuntimeException("todo"));

        if (orderItem.getQuantity() == 1) {
            throw new OrderItemLessThanOneException();
        }
        orderItem.setQuantity(orderItem.getQuantity() - 1);

        orderItemRepository.save(orderItem);
    }


    public List<ProductCartDto> getProductCarts() {
        List<ProductCart> all = productCartRepository.findAll();
        return productCartMapper.toDtos(all);
    }

    public ProductCart getSingleProductCart(long id) {
        return productCartRepository.findById(id).orElseThrow();
    }

    public ProductCartDto addProductCart(ProductCartDto productCartDto) {
        ProductCart savedProductCart = productCartRepository.save(productCartMapper.toEntity(productCartDto));
        return productCartMapper.toDto(savedProductCart);
    }

    public boolean checkIfExists(ProductCart productCart) {
        return productCartRepository.existsById(productCart.getId());
    }
}
