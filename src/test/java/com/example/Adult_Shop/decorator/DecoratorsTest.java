package com.example.Adult_Shop.decorator;

import com.example.Adult_Shop.factory.ToyFactory;
import com.example.Adult_Shop.product.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DecoratorsTest {

    private ToyFactory toyFactory = new ToyFactory();

    @Test
    void addDecoratorsTest() {
        String packagingStyle = "private";

        Product product = toyFactory.createProduct(1, "Кролик", 22);
        Product decorProduct1 = new DiscreetPackagingDecorator(packagingStyle, product);
        Product decorProduct2 = new ExpressDeliveryDecorator(product);
        Product decorProduct3 = new ExpressDeliveryDecorator(new DiscreetPackagingDecorator(packagingStyle, product));

        assertEquals(27, decorProduct1.getPrice());
        assertEquals(22.5, decorProduct2.getPrice());
        assertEquals(27.5, decorProduct3.getPrice());
    }
}
