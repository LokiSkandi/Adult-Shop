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
        weightInGrams = legacyShippingService.calculateShippingCost("",1) * 453,59;
        return weightInGrams;
    }


}
