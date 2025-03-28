package org.example.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.example.payments.PaymentResponse.PaymentStatus.*;

public class PaymentProcessorTest {
    private PaymentProcessor paymentProcessor;
    private PaymentGateway paymentGateway;

    @Before
    public void setup() {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void paiment_success() {
        Mockito.when(paymentGateway.pay(Mockito.any())).thenReturn(new PaymentResponse(SUCCESS));

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void paiment_fail() {
        Mockito.when(paymentGateway.pay(Mockito.any())).thenReturn(new PaymentResponse(FAIL));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}