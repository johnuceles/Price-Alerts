package com.houseHunting.priceAlerts;


import com.houseHunting.priceAlerts.observer.PriceChangeObserver;
import com.houseHunting.priceAlerts.observer.PriceFallObserver;
import com.houseHunting.priceAlerts.observer.PriceRiseObserver;
import com.houseHunting.priceAlerts.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.LinkedList;

@RunWith(MockitoJUnitRunner.class)
public class PriceChangeTest {

    @Test
    public void testPriceChange() {

        System.out.println("\n\nSetting price to 300,000 to start with.");
        Subject subject = new Subject(new LinkedList<>(), 300000L, 5000000L);

        new PriceRiseObserver(subject);
        new PriceFallObserver(subject);
        new PriceChangeObserver(subject);

        subject.notifyObservers();

        System.out.println("\n\n-------------------------------------------------------------------------------*****New Test*****-------------------------------------------------------------------------------");
        System.out.println("\n\nInitiating price hike test. Setting price to 500,000.");
        subject.setCurrentPrice(500000L);

        System.out.println("\n\n-------------------------------------------------------------------------------*****New Test*****-------------------------------------------------------------------------------");
        System.out.println("\n\nInitiating price fall test. Setting price to 100,000.");
        subject.setCurrentPrice(100000L);

        System.out.println("\n\n-------------------------------------------------------------------------------*****New Test*****-------------------------------------------------------------------------------");
        System.out.println("\n\nInitiating another price hike test. Setting price to 1,000,000.");
        subject.setCurrentPrice(1000000L);

        System.out.println("\n\n-------------------------------------------------------------------------------*****New Test*****-------------------------------------------------------------------------------");
        System.out.println("\n\nInitiating another price fall test. Setting price to 150,000.");
        subject.setCurrentPrice(150000L);
    }
}
