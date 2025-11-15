public interface PaymentProcessor {
    void processPayment(double amount, int method, String cardNumber, String expiry, String cvv);
}
