package com.houseHunting.priceAlerts.service;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String price);
}
