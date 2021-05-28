package com.example.shop;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
//@WebMvcTest(ProductController.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerUnitTest {
//
    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    ProductService productService;

    @Test
    void shouldGetSingleProduct() throws Exception {
        mockMvc.perform(get("/products/1"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.id", Matchers.is(1)));
    }
}
