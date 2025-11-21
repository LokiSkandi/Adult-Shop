package com.example.Adult_Shop.facade;

import com.example.Adult_Shop.enumeration.ShoppingCart;
import com.example.Adult_Shop.enumeration.ShoppingCartTest;
import com.example.Adult_Shop.payment.PaymentDetails;
import com.example.Adult_Shop.processors.PaymentProcessor;
import com.example.Adult_Shop.service.InventoryService;
import com.example.Adult_Shop.service.NotificationService;
import com.example.Adult_Shop.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderFacadeTest {
    @Mock
    private InventoryService inventoryService;
    @Mock
    private PaymentProcessor paymentProcessor;
    @Mock
    private OrderService orderService;
    @Mock
    private NotificationService notificationService;
    private ShoppingCart cart = ShoppingCart.INSTANCE;

    @Test
    void placeOrder_Test() {
        OrderFacade facade = new OrderFacade(inventoryService, paymentProcessor, orderService, notificationService);
        PaymentDetails details = new PaymentDetails();

        when(paymentProcessor.checkPayment()).thenReturn(true);
        when(inventoryService.checkInventory()).thenReturn(true);
        when(orderService.createOrder()).thenReturn("Заказ создан");
        when(notificationService.shipmentNotification()).thenReturn("Всё прошло успешно");

        assertEquals("Заказ создан! Всё прошло успешно", facade.placeOrder(cart, details));
        verify(paymentProcessor, times(1)).checkPayment();
        verify(inventoryService, times(1)).checkInventory();
        verify(orderService, times(1)).createOrder();
        verify(notificationService, times(1)).shipmentNotification();
    }
}
