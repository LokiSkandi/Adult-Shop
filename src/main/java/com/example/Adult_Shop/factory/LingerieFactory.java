package com.example.Adult_Shop.factory;

import com.example.Adult_Shop.enumeration.Size;
import com.example.Adult_Shop.product.Lingerie;

public class LingerieFactory extends ProductFactory{

    @Override
    public Lingerie createProduct(long id, String name, double price) {
        Lingerie lingerie = new Lingerie(id, name, price);
        if(price < 4) {
            throw new IllegalArgumentException("Цена не может быть меньше 4$");
        }
        return lingerie;
    }

    public Lingerie createProduct (long id, String name, double price, Size size, String color) {
        Lingerie lingerie = new Lingerie(id, name, price, size, color);
        if(price < 4) {
            throw new IllegalArgumentException("Цена не может быть меньше 4$");
        }
        return lingerie;
    }
}
