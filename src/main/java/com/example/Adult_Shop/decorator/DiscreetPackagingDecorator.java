package com.example.Adult_Shop.decorator;

import com.example.Adult_Shop.product.Product;

public class DiscreetPackagingDecorator extends ProductDecorator{

    private String packagingStyle;
    private static final double DISCREET_PACKAGING_COST = 5.0;


    public DiscreetPackagingDecorator(Product product) {
        super(product);
    }
    public DiscreetPackagingDecorator(String packagingStyle, Product product) {
        super(product);
        this.packagingStyle = packagingStyle;
    }

    @Override
    public double getPrice() {
        return decoraterProduct.getPrice() + DISCREET_PACKAGING_COST;
    }

}
