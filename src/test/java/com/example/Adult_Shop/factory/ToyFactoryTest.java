package com.example.Adult_Shop.factory;

import com.example.Adult_Shop.product.Product;
import com.example.Adult_Shop.product.Toy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ToyFactoryTest {

    private  ToyFactory toyFactory = new ToyFactory();

    @Test
    public void toyFactory_ShouldCreateToyInstance(){
        // Given
        long id = 1;
        String name = "Кролик";
        double price = 11.00;
        //When
        Product product = toyFactory.createProduct(id, name, price);
        //Then
        assertNotNull(product, "Продукт не должен быть null");
        assertTrue(product instanceof Toy, "Фабрика должна создавать экземпляр Toy");
    }

    @Test
    public void toyFactory_ShouldThrowExceptionWhenPriceTooLow() {
        long id = 1;
        String name = "Кролик";
        double price = 9.00;

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> toyFactory.createProduct(id, name, price));
        assertEquals("Цена не может быть меньше 10$",  illegalArgumentException.getMessage());
    }

    @Test
    public void createdToy_ShouldHaveCorrectProperties() {
        long id = 1;
        String name = "Кролик";
        double price = 11.00;

        Product product = toyFactory.createProduct(id, name, price);
        Toy toy = (Toy) product;

        assertEquals("silicone", toy.getMaterial());
        assertTrue(toy.isWaterproof());
        assertEquals(price, toy.getPrice());
        assertEquals(name, toy.getName());
        assertEquals(id, toy.getId());
    }

    @Test
    @DisplayName("")
    public void toyFactoryWithCustomParams_ShouldCreateToyWithCorrectSpecs() {
        long id = 1;
        String name = "Кролик";
        double price = 11.00;
        String material = "glass";
        boolean waterproof = true;

        Product product = toyFactory.createProduct(id, name, price, material, waterproof);
        Toy toy = (Toy) product;

        assertEquals("glass", toy.getMaterial());
        assertTrue(toy.isWaterproof());
    }
}
