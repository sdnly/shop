package com.example.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Async
    public void sendMail(String to, String subject, String text, boolean isHtmlContent) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
//        ByteArrayDataSource byteArrayDataSource = null;
//        byteArrayDataSource = new ByteArrayDataSource(attachement, "application/txt");
//        mimeMessageHelper.addAttachment(byteArrayDataSource.getName(), byteArrayDataSource);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isHtmlContent);
        javaMailSender.send(mimeMessage);
    }
}
