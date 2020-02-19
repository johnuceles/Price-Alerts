package com.houseHunting.priceAlerts.observer;

import com.houseHunting.priceAlerts.subject.Subject;

public class PriceRiseObserver extends PriceObserver {

    public PriceRiseObserver(Subject subject) {
        this.threshHoldPrice = 750000L;
        subscribeToSubject(subject);
    }

    @Override
    public void update() {

        Long priceChange = calculatePriceDifference(subject);

        if(subject.getUpdatedPrice() > threshHoldPrice) {
            System.out.println("\n\nNotification from Price Rise Observer (Notifies when price rises above $750,0000)");
            System.out.println("\n---------------------------------------------------------------------------------");
            System.out.println("\nPrice hiked by: $" + (priceChange) + ".\nCurrent price: $" + subject.getUpdatedPrice() + ".\n\n");
        }
        else
            System.out.println("\n\nPriceRiseObserver was notified, but no other logs to print");
    }
}
