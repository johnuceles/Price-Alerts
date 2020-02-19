package com.houseHunting.priceAlerts.observer;

import com.houseHunting.priceAlerts.subject.Subject;

public class PriceFallObserver extends PriceObserver {

    public PriceFallObserver(Subject subject) {
        this.threshHoldPrice = 250000L;
        subscribeToSubject(subject);
    }

    @Override
    public void update() {

        Long priceChange = calculatePriceDifference(subject);

        if(subject.getUpdatedPrice() < threshHoldPrice) {
            System.out.println("\n\nNotification from Price Fall Observer (Notifies when price falls below $250,0000)");
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.println("\nPrice fell by: $" + (priceChange) + ".\nCurrent price: $" + subject.getUpdatedPrice() + ".\n\n");
        }
        else
            System.out.println("\n\nPriceFallObserver was notified, but no other logs to print");
    }
}

