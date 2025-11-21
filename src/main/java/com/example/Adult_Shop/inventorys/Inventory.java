package com.example.Adult_Shop.inventorys;

import com.example.Adult_Shop.product.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(Product product) {
        products.add(product);
    }
}
