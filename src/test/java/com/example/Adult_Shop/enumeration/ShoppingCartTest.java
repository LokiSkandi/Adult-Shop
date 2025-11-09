package com.example.Adult_Shop.enumeration;

import com.example.Adult_Shop.factory.LingerieFactory;
import com.example.Adult_Shop.factory.ToyFactory;
import com.example.Adult_Shop.product.GiftSet;
import com.example.Adult_Shop.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {

    ShoppingCart cart;
    LingerieFactory lingerieFactory = new LingerieFactory();
    ToyFactory toyFactory = new ToyFactory();
    GiftSet giftSet = new GiftSet();


    @BeforeEach
    void setUp() {
        cart = ShoppingCart.INSTANCE;
        ShoppingCart.INSTANCE.clear();
    }

    @Test
    void checkingForSameness () {
        ShoppingCart cart1 = ShoppingCart.INSTANCE;
        ShoppingCart cart2 = ShoppingCart.INSTANCE;

        assertEquals(cart1, cart2);
    }

    @Test
    void testCalculateTotal() {
        Product p1 = lingerieFactory.createProduct(1, "Бельё", 20.0, Size.S, "Red");
        Product p2 = toyFactory.createProduct(1L,"Кролик", 30.0, "Латекс", true);
        Product mainProduct = toyFactory.createProduct(2, "Вуманайзер", 11);
        List<Product> additionalProducts = new ArrayList<>();
        additionalProducts.add(lingerieFactory.createProduct(56, "Бельё", 6, Size.S, "red"));
        additionalProducts.add(lingerieFactory.createProduct(55, "Бельё", 6, Size.S, "blue"));
        Product p3 = giftSet.builder()
                .mainProduct(mainProduct)
                .additionalProducts(additionalProducts)
                .hasGiftWrap(true)
                .cardMessage("Сюрприз!")
                .build();

        double price = 73.0;

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        assertEquals(price, cart.calculateTotal());
    }

    @Test
    void testRemoveProduct() {
        Product p1 = lingerieFactory.createProduct(1, "Бельё", 20.0, Size.S, "Red");
        Product p2 = toyFactory.createProduct(1L,"Кролик", 30.0, "Латекс", true);
        double price = 30.0;

        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.removeProduct(p1);

        assertEquals(price, cart.calculateTotal());
    }

    @Test
    void testExeption() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));

        assertEquals("Добавьте существующий подукт", illegalArgumentException.getMessage());
    }
}
