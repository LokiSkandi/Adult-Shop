package com.example.Adult_Shop.decorator;

import com.example.Adult_Shop.product.Product;

public abstract class ProductDecorator extends Product {

    protected Product decoraterProduct;

    public ProductDecorator(Product decoraterProduct) {
        super(decoraterProduct.getId(),  decoraterProduct.getName(), decoraterProduct.getPrice());
        this.decoraterProduct = decoraterProduct;
    }

    @Override
    public long getId () {
        return decoraterProduct.getId();
    }
    @Override
    public String getName () {
        return decoraterProduct.getName();
    }

    @Override
    public abstract double getPrice();

    public double getBasePrice() {
        return decoraterProduct.getPrice();
    }
}
