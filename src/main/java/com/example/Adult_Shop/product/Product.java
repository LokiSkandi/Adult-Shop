package com.example.Adult_Shop.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Product {
    long id;
    String name;
    double price;


}
