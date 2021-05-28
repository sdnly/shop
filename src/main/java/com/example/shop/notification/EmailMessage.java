package com.example.shop.notification;

import com.example.shop.model.Product;
import com.example.shop.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class EmailMessage implements Observer{

    //TODO CUSTOMERMAIL BASICALLY EVERYTHING

//    private final MailService mailService;
    private ProductRepository productRepository;


    public void update(Product product) {
        System.out.println("Produkt: " + product.getName() + " powrócił na stan");
//        var theProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("todoxd"));
//        try {
//
//            mailService.sendMail("koks@koks.com",
//                                 " Produkt: " + "testosteron 500",
//                                  " powrócil na stan", true);
//        } catch (MessagingException | IOException e) {
//            e.printStackTrace();
//        }
    }
}
