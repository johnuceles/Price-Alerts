package com.houseHunting.priceAlerts.subject;

import com.houseHunting.priceAlerts.observer.PriceObserver;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Subject {

    List<PriceObserver> priceObservers;

    private Long currentPrice;

    private Long updatedPrice;

    public void setUpdatedPrice(Long updatedPrice) {

        this.updatedPrice = updatedPrice;
        notifyObservers();
    }

    public void notifyObservers(){

        priceObservers.forEach(PriceObserver::update);
    }

}