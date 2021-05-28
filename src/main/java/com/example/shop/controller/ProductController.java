package com.example.shop.controller;

import com.example.shop.dto.ProductDto;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/subscribe")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void subscribe(long id) {
        productService.subscribe(id);
    }

    @GetMapping("/byPrice")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> sortedProductsByPrice() {
        return productService.sortedProductsByPrice();
    }

    @GetMapping("/byInStock")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> sortedProductsByInStock() {
        return productService.sortedProductsByInStock();
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getSingleProduct(@PathVariable long id) {
        return productService.getSingleProduct(id);
    }

    @PutMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ProductDto editProduct(@RequestBody ProductDto productDto) {
        return productService.editProduct(productDto);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }


}
