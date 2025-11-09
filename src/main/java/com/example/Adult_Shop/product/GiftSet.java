package com.example.Adult_Shop.product;


import lombok.*;

import java.util.List;


@Data
@Builder
public class GiftSet extends Product {

    private Product mainProduct;
    private List<Product> additionalProducts;
    private boolean hasGiftWrap;
    private String cardMessage;

    public GiftSet(Product mainProduct, List<Product> additionalProducts, boolean hasGiftWrap, String cardMessage) {

        if (mainProduct == null) {
            throw new IllegalArgumentException("Набор должен содержать основной товар!");
        }
        this.mainProduct = mainProduct;
        this.additionalProducts = additionalProducts;
        this.hasGiftWrap = hasGiftWrap;
        this.cardMessage = cardMessage;
    }

    public GiftSet(long id, String name, double price, Product mainProduct, List<Product> additionalProducts, boolean hasGiftWrap, String cardMessage) {

        super(id, name, price);

        if (mainProduct == null) {
            throw new IllegalArgumentException("Набор должен содержать основной товар!");
        }
        this.mainProduct = mainProduct;
        this.additionalProducts = additionalProducts;
        this.hasGiftWrap = hasGiftWrap;
        this.cardMessage = cardMessage;
    }

    public GiftSet() {
        super();
    }

    @Override
    public double getPrice() {

        double totalPrice = mainProduct.getPrice();
        if (additionalProducts != null) {
            for (Product product : additionalProducts) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
}
