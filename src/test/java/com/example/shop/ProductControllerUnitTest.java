package com.example.shop;

import com.example.shop.controller.ProductController;
import com.example.shop.dto.ProductDto;
import com.example.shop.model.Product;
import com.example.shop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@RunWith(SpringRunner.class)
//@WebMvcTest(ProductController.class)
@SpringBootTest
public class ProductControllerUnitTest {
//
//    @Autowired
//    private MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void shouldGetSingleProducts() {
        ProductDto singleProduct = productService.getSingleProduct(1L);

        assertThat(singleProduct).isNotNull();
        assertThat(singleProduct.getId()).isEqualTo(1L);
    }
}
