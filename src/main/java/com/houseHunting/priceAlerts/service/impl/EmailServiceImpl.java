package com.houseHunting.priceAlerts.service.impl;

import com.houseHunting.priceAlerts.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String price) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);

        String messageBody = "The price of the house you were looking at, has changed. The new price is $" + price;
        message.setText(messageBody);

        emailSender.send(message);
    }
}