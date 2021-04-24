package com.example.shop.controller;

import com.example.shop.model.Order;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

        private final OrderService orderService;


        @GetMapping
        public Order getOrder(@RequestParam long id) {
            return orderService.getOrder(id);
        }

        @PostMapping
        public void cartToOrder(@RequestParam long id, long billingId, long shippingId) {
            orderService.cartToOrder(id, billingId, shippingId);
        }

}
