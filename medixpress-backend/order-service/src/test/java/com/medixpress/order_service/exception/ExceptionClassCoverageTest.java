package com.medixpress.order_service.exception;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionClassCoverageTest {

    @Test
    void testCartEmptyException() {
        CartEmptyException ex = new CartEmptyException("Cart is empty");
        assertEquals("Cart is empty", ex.getMessage());
    }

    @Test
    void testOrderNotFoundException() {
        OrderNotFoundException ex = new OrderNotFoundException("Order not found");
        assertEquals("Order not found", ex.getMessage());
    }

    @Test
    void testOutForDeliveryException() {
        OutForDeliveryException ex = new OutForDeliveryException("Already out for delivery");
        assertEquals("Already out for delivery", ex.getMessage());
    }

    @Test
    void testOutOfStockException() {
        OutOfStockException ex = new OutOfStockException("Out of stock");
        assertEquals("Out of stock", ex.getMessage());
    }

    @Test
    void testUnauthorizedAccessException() {
        UnauthorizedAccessException ex = new UnauthorizedAccessException("Unauthorized access");
        assertEquals("Unauthorized access", ex.getMessage());
    }

    @Test
    void testMedixpressException() {
        MedixpressException ex = new MedixpressException("Base exception");
        assertEquals("Base exception", ex.getMessage());
    }
}

