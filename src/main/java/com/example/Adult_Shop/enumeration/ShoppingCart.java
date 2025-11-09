package com.example.Adult_Shop.enumeration;

import com.example.Adult_Shop.product.Product;

import java.util.ArrayList;
import java.util.List;

public enum ShoppingCart {

    INSTANCE;

    private List<Product> products;


    private ShoppingCart() {
        products = new ArrayList<>();
    }
    public void addProduct(Product p) {
        if (p == null) {
            throw new IllegalArgumentException("Добавьте существующий подукт");
        }
        products.add(p);
    }
    public void removeProduct(Product p) {
        products.remove(p);
    }
    public double calculateTotal() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
    public void clear() {
        products.clear();
    }
}
