package com.example.Adult_Shop.product;

import com.example.Adult_Shop.enumeration.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Lingerie extends Product{

    Size size;
    String color;

    public Lingerie(long id, String name, double price) {
        super(id, name, price);
        this.size = Size.M;
        this.color = "red";
    }

    public Lingerie(long id, String name, double price, Size size, String color) {
        super(id, name, price);
        this.size = size;
        this.color = color;
    }

    public Lingerie() {
        super();
    }
}
