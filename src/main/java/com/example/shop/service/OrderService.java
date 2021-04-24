package com.example.shop.service;

import com.example.shop.model.BillingAddress;
import com.example.shop.model.Order;
import com.example.shop.model.ProductCart;
import com.example.shop.model.ShippingAddress;
import com.example.shop.repository.BillingAddressRepository;
import com.example.shop.repository.OrderRepository;
import com.example.shop.repository.ProductCartRepository;
import com.example.shop.repository.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductCartRepository productCartRepository;
    private final ShippingAddressRepository shippingAddressRepository;
    private final BillingAddressRepository billingAddressRepository;


    public void cartToOrder(long id, long billingId, long shippingId) {
        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
        ShippingAddress shippingAddress = shippingAddressRepository.findById(shippingId).orElseThrow();
        BillingAddress billingAddress = billingAddressRepository.findById(billingId).orElseThrow();
        Order order = new Order();
        order.setProductCart(productCart);
        order.setBillingAddress(billingAddress);
        order.setShippingAddress(shippingAddress);

        orderRepository.save(order);
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }


}
