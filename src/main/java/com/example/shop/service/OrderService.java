package com.example.shop.service;

import com.example.shop.dto.OrderMapper;
import com.example.shop.model.BillingAddress;
import com.example.shop.model.Order;
import com.example.shop.model.OrderItem;
import com.example.shop.model.ShippingAddress;
import com.example.shop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductCartRepository productCartRepository;
    private final ShippingAddressRepository shippingAddressRepository;
    private final BillingAddressRepository billingAddressRepository;
    private final MailService mailService;
    private final OrderItemRepository orderItemRepository;
    private final OrderMapper orderMapper;


    public void checkOut(long id, long billingId, long shippingId) throws MessagingException, IOException {

        List<OrderItem> all = orderItemRepository.findAll();

        ShippingAddress shippingAddress = shippingAddressRepository.findById(shippingId).orElseThrow();
        BillingAddress billingAddress = billingAddressRepository.findById(billingId).orElseThrow();
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setOrderItemList(all);
        order.setBillingAddress(billingAddress);
        order.setShippingAddress(shippingAddress);
        mailService.sendMail(String.valueOf(shippingAddress.getMail()),
                "Zamowienie nr " + UUID.randomUUID(),
                String.valueOf(order.getId()), true);

        orderRepository.save(order);

        var savedOrder = orderRepository.findById(order.getId()).orElseThrow(() -> new RuntimeException("zadyma?"));
        saveOrderToFile(savedOrder);
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public List<Order> sortedOrders() {
        List<Order> all = orderRepository.findAll();
        List<Order> collect = all.stream()
                .sorted(Comparator.comparing(Order::getCreatedAt))
                .collect(Collectors.toList());

        return collect;
    }

    public void saveOrderToFile(Order order) throws IOException {
        var zadyma = orderRepository.findById(order.getId()).orElseThrow(() -> new RuntimeException("zadyma"));

        PrintWriter outputFile = new PrintWriter("order.txt");

        outputFile.println(order);
        outputFile.close();
    }


}
