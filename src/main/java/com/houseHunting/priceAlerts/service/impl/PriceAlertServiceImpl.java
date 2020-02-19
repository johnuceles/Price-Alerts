package com.houseHunting.priceAlerts.service.impl;

import com.houseHunting.priceAlerts.domain.PriceInfo;
import com.houseHunting.priceAlerts.observer.PriceChangeObserver;
import com.houseHunting.priceAlerts.observer.PriceFallObserver;
import com.houseHunting.priceAlerts.observer.PriceRiseObserver;
import com.houseHunting.priceAlerts.repository.PriceRepository;
import com.houseHunting.priceAlerts.service.EmailService;
import com.houseHunting.priceAlerts.service.PriceAlertService;
import com.houseHunting.priceAlerts.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Objects;

@Service
public class PriceAlertServiceImpl implements PriceAlertService {

    private EmailService emailService;

    private PriceRepository priceRepository;

    private Subject subject;

    public PriceAlertServiceImpl(EmailService emailService, PriceRepository priceRepository) {
        this.emailService = emailService;
        this.priceRepository = priceRepository;
    }

    @Override
    public void updatePrice(Long houseId, Long updatedPrice) {

        PriceInfo priceInfo = priceRepository.findByHouseId(houseId);

        if(Objects.nonNull(priceInfo)) {

            if(Objects.isNull(subject))
                createSubject(updatedPrice, priceInfo.getAmount());
            else
                subject.setUpdatedPrice(updatedPrice);

            emailService.sendSimpleMessage("appuceles@gmail.com", "Here is your new price", updatedPrice.toString());
        }
    }

    private void createSubject(Long updatedPrice, Long currentPrice) {

        subject = new Subject(new LinkedList<>(), currentPrice, updatedPrice);
        createObservers();
        subject.notifyObservers();
    }

    private void createObservers() {

        new PriceRiseObserver(subject);
        new PriceFallObserver(subject);
        new PriceChangeObserver(subject);
    }
}
