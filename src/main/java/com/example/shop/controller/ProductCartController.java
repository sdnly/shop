package com.example.shop.controller;

import com.example.shop.model.Product;
import com.example.shop.model.ProductCart;
import com.example.shop.service.ProductCartService;
import com.example.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ProductCartController {

    private final ProductCartService productCartService;
    private final ProductService productService;

//    @GetMapping("/{id}")
//    public ProductCart getSingleProductCart(@PathVariable long id) {
//        return productCartService.getSingleProductCart(id);
//    }
//

    @PostMapping("/add")
    public void addToCart(@RequestParam long id, int quantity) {
        productCartService.addToCart(id, quantity);
    }

    @DeleteMapping("/delete")
    public void removeFromCart(@RequestParam long id, long productId, int quantity) {
        productCartService.removeFromCart(id, productId, quantity);
    }

    @GetMapping
    public ProductCart getProductCart(@RequestParam long id) {
        return productCartService.getSingleProductCart(id);
    }

//    @GetMapping
//    public List<ProductCart> getListItems() {
//        return productCartService.getListItems();
//    }


    @PostMapping
    public ProductCart addProductCart(@RequestBody ProductCart productCart) throws Exception {
//        if(productCartService.checkIfExists(productCart)) {
//            throw new Exception("Juz jes");
//        }
        return productCartService.addProductCart(productCart);
    }
}
