package org.example.payments;

public class PaymentProcessor {
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentResponse paymentResponse = paymentGateway.pay(new PaymentRequest(amount));
        if(paymentResponse.getStatus() == PaymentResponse.PaymentStatus.SUCCESS){
            return true;
        } else {
            return false;
        }
    }

}
