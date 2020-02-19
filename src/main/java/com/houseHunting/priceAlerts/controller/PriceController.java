package com.houseHunting.priceAlerts.controller;


import com.houseHunting.priceAlerts.service.PriceAlertService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/houses/{id}/price")
public class PriceController {

    private PriceAlertService priceAlertService;

    public PriceController(PriceAlertService priceAlertService) {
        this.priceAlertService = priceAlertService;
    }

    @PutMapping()
    public void updatePrice(@PathVariable Long id, @RequestBody Long price) {

        priceAlertService.updatePrice(id, price);
    }
}
