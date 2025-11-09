package com.example.Adult_Shop.service;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LegacyShippingService {

    public double calculateShippingCost(String postcode, double weightInPounds) {
        return weightInPounds;
    }
}
