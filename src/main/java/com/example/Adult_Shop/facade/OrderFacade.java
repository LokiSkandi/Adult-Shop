package com.example.Adult_Shop.facade;

import com.example.Adult_Shop.enumeration.ShoppingCart;
import com.example.Adult_Shop.payment.PaymentDetails;
import com.example.Adult_Shop.processors.PaymentProcessor;
import com.example.Adult_Shop.service.InventoryService;
import com.example.Adult_Shop.service.NotificationService;
import com.example.Adult_Shop.service.OrderService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderFacade {

    private InventoryService inventoryService;
    private PaymentProcessor paymentProcessor;
    private OrderService orderService;
    private NotificationService notificationService;

    public String placeOrder(ShoppingCart cart, PaymentDetails details) {
        if(!inventoryService.checkInventory()) {
            throw new IllegalArgumentException("Нет товара на складе");
        }
        if (!paymentProcessor.checkPayment()) {
            throw new IllegalArgumentException("Оплата не прошла");
        }

        String massageOrder = orderService.createOrder();
        String notification = notificationService.shipmentNotification();

        return massageOrder + "! " + notification;
    }
}
