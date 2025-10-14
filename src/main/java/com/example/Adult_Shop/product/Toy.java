package com.example.Adult_Shop.product;

import lombok.Data;

@Data
public class Toy extends Product {

    String material;
    boolean isWaterproof;

    public Toy(long id, String name, double price) {
        super(id, name, price);
        this.material = "silicone";
        this.isWaterproof = true;
    }

    public Toy(long id, String name, double price, String material, boolean isWaterproof) {
        super(id, name, price);
        this.material = material;
        this.isWaterproof =  isWaterproof;
    }

    public Toy() {
        super();
    }
}
