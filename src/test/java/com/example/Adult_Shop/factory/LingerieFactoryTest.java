package com.example.Adult_Shop.factory;

import com.example.Adult_Shop.enumeration.Size;
import com.example.Adult_Shop.product.Lingerie;
import com.example.Adult_Shop.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LingerieFactoryTest {

    private  LingerieFactory lingerieFactory =new LingerieFactory();

    @Test
    @DisplayName("Проверка на создание Lingerie")
    public void lingerieFactory_ShouldCreateToyInstance() {
        long id = 1;
        String name = "Бельё";
        double price = 10.0;

        Product product = lingerieFactory.createProduct(id, name, price);

        assertNotNull(product, "Продукт не должен быть null");
        assertTrue(product instanceof Lingerie, "Фабрика должна создавать экземпляр Lingerie");
    }

    @Test
    @DisplayName("Проверка на стоимость")
    public void lingerieFactory_ShouldThrowExceptionWhenPriceTooLow() {
        long id = 1;
        String name = "Бельё";
        double price = 1.0;

        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> lingerieFactory.createProduct(id, name, price));

        assertEquals("Цена не может быть меньше 4$",  illegalArgumentException.getMessage());
    }

    @Test
    @DisplayName("Проверка на цвет и размер")
    public void createdLingerie_ShouldHaveCorrectProperties() {
        long id = 1;
        String name = "Бельё";
        double price = 10.00;

        Product product = lingerieFactory.createProduct(id, name, price);
        Lingerie lingerie = (Lingerie) product;

        assertEquals(Size.M, lingerie.getSize());
        assertEquals("red", lingerie.getColor());
        assertEquals(price, lingerie.getPrice());
        assertEquals(name, lingerie.getName());
        assertEquals(id, lingerie.getId());
    }

    @Test
    @DisplayName("Проверка на изменение параметров")
    public void lingerieFactoryWithCustomParams_ShouldCreateLingerieWithCorrectSpecs() {
        long id = 1;
        String name = "Бельё";
        double price = 10.00;
        String color = "blue";
        Size size = Size.XL;

        Product product = lingerieFactory.createProduct(id, name, price, size, color);
        Lingerie lingerie = (Lingerie) product;

        assertEquals("blue", lingerie.getColor());
        assertEquals(Size.XL, lingerie.getSize());
    }
}
