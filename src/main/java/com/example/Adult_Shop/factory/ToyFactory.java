package com.example.Adult_Shop.factory;

import com.example.Adult_Shop.product.Toy;

public class ToyFactory extends ProductFactory{

    @Override
    public Toy createProduct(long id, String name, double price) {
        Toy toy = new Toy(id, name, price);
        if(price < 10) {
            throw new IllegalArgumentException("Цена не может быть меньше 10$");
        }
        return toy;
    }

    public Toy createProduct(Long id, String name, double price, String material, boolean isWaterproof) {
        Toy toy = new Toy(id, name, price, material, isWaterproof);
        if(price < 10) {
            throw new IllegalArgumentException("Цена не может быть меньше 10$");
        }
        return toy;
    }
}
