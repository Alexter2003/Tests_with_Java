package org.example.payments;

public class PaymentResponse {
    enum PaymentStatus {
        SUCCESS, FAIL
    }

    private PaymentStatus status;

    public PaymentResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
