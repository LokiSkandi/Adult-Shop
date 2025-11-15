package com.example.Adult_Shop.service;

import lombok.Data;

@Data
public class ModernShippingCalculatorImpl implements ModernShippingCalculator {

    private final LegacyShippingService legacyShippingService;

    public ModernShippingCalculatorImpl(LegacyShippingService legacyShippingService) {
        this.legacyShippingService = legacyShippingService;
    }

    @Override
    public double calculatePrice(int postcode, double weightInGrams) {
        double weightInPounds =  weightInGrams * 453.5;
        return legacyShippingService.calculateShippingCost(String.valueOf(postcode), weightInPounds);
    }


}
