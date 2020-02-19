package com.houseHunting.priceAlerts.observer;


import com.houseHunting.priceAlerts.subject.Subject;

public abstract class PriceObserver {

    protected Subject subject;

    protected Long threshHoldPrice;

    public abstract void update();

    public void subscribeToSubject(Subject subject) {
        this.subject = subject;
        subject.getPriceObservers().add(this);
    }

    public Long calculatePriceDifference(Subject subject){
        return Math.abs(subject.getUpdatedPrice() - subject.getCurrentPrice());
    }
}