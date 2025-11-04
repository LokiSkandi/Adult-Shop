package com.example.Adult_Shop.factory;

import com.example.Adult_Shop.product.Product;
import lombok.Data;

@Data
public abstract class ProductFactory {

    public abstract Product createProduct(long id, String name, double price);
}
