package org.example.payments;

public interface PaymentGateway {

    PaymentResponse pay(PaymentRequest paymentRequest);
}
