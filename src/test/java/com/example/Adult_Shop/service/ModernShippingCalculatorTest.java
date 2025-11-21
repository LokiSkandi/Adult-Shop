package com.example.Adult_Shop.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModernShippingCalculatorTest {

    ModernShippingCalculatorImpl modernShippingCalculator = new ModernShippingCalculatorImpl(new LegacyShippingService());

    @Test
    public void testModernShippingCalculator() {
       double m = modernShippingCalculator.calculatePrice(1, 1);

       assertEquals(453.5, m);
    }
}
