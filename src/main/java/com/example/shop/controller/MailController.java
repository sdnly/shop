package com.example.shop.controller;

import com.example.shop.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/sendMail")
    public String sendMail() throws MessagingException, IOException {
        mailService.sendMail("xddxd@xd.com",
                "Jest koks",
                "koksik", true);
        return "ok";
    }
}
