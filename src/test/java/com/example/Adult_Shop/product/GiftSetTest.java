package com.example.Adult_Shop.product;

import com.example.Adult_Shop.enumeration.Size;
import com.example.Adult_Shop.factory.LingerieFactory;
import com.example.Adult_Shop.factory.ToyFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GiftSetTest {

    private ToyFactory toyFactory = new ToyFactory();
    private LingerieFactory lingerieFactory = new LingerieFactory();

    @Test
    @DisplayName("Проверка на создание набора")
    public void giftSet_ShouldСreate() {
        Product mainProduct = toyFactory.createProduct(2, "Кролик", 11);
        List<Product> additionalProducts = new ArrayList<>();

        additionalProducts.add(lingerieFactory.createProduct(56, "Бельё", 6.87, Size.S, "red"));
        additionalProducts.add(lingerieFactory.createProduct(55, "Бельё", 6.87, Size.S, "blue"));
        GiftSet giftSet = GiftSet.builder()
                .mainProduct(mainProduct)
                .additionalProducts(additionalProducts)
                .hasGiftWrap(true)
                .cardMessage("Сюрприз!")
                .build();

        assertNotNull(giftSet, "Продукт не должен быть null");
        assertTrue(giftSet instanceof GiftSet,  "должн создавать экземпляр GiftSet");
        assertTrue(giftSet.isHasGiftWrap());
        assertEquals("Сюрприз!", giftSet.getCardMessage());
    }

    @Test
    @DisplayName("Проверка на выброс ошибки при попытке создания набора без mainProduct")
    public void giftSet_ShouldThrowExceptionWhenMainProductIsNull() {

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> GiftSet.builder()
                .hasGiftWrap(true)
                .cardMessage("ХА! Тут ничего нет!")
                .build());
        assertEquals("Набор должен содержать основной товар!", exception.getMessage());
    }


}
