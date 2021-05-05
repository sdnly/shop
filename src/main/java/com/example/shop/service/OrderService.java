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

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService extends Thread {

    private final OrderRepository orderRepository;
    private final ProductCartRepository productCartRepository;
    private final ShippingAddressRepository shippingAddressRepository;
    private final BillingAddressRepository billingAddressRepository;
    private final MailService mailService;


    public void checkOut(long id, long billingId, long shippingId) throws MessagingException, IOException {
        ProductCart productCart = productCartRepository.findById(id).orElseThrow();
        ShippingAddress shippingAddress = shippingAddressRepository.findById(shippingId).orElseThrow();
        BillingAddress billingAddress = billingAddressRepository.findById(billingId).orElseThrow();
        Order order = new Order();
        order.setProductCart(productCart);
        order.setBillingAddress(billingAddress);
        order.setShippingAddress(shippingAddress);

        saveOrderToFile(productCart.getId());

        mailService.sendMail(String.valueOf(shippingAddress.getMail()),
                "Zamowienie nr " + UUID.randomUUID(),
                String.valueOf(order.getProductCart()),true);


        orderRepository.save(order);
    }

    public Order getOrder(long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public void saveOrderToFile(long id) throws IOException {
        var productCart = productCartRepository.findById(id).orElseThrow();

        PrintWriter outputFile = new PrintWriter("order.txt");

        outputFile.println(productCart);
        outputFile.close();
    }


}
