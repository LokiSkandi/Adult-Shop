package com.example.Adult_Shop.decorator;

import com.example.Adult_Shop.product.Product;

public class ExpressDeliveryDecorator extends  ProductDecorator {

    private static final double DISCREET_EXPRESS_DELIVERY_COST = 0.5;

    public ExpressDeliveryDecorator(Product product) {
        super(product);
    }

    @Override
    public double getPrice() {
        return decoraterProduct.getPrice() + DISCREET_EXPRESS_DELIVERY_COST;
    }
}
