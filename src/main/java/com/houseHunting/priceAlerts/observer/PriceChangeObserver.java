package com.houseHunting.priceAlerts.observer;

import com.houseHunting.priceAlerts.subject.Subject;
import lombok.Data;

@Data
public class PriceChangeObserver extends PriceObserver {

    public PriceChangeObserver(Subject subject) {
        subscribeToSubject(subject);
    }

    @Override
    public void update() {

        Long priceChange = calculatePriceDifference(subject);

        if(priceChange != 0L) {
            System.out.println("\n\nNotification from Price Change Observer (Notifies whenever there is a price change)");
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println("\nPrice changed by: $" + (priceChange) + ".\nCurrent price: $" + subject.getUpdatedPrice() + ".\n\n");
        }
    }
}