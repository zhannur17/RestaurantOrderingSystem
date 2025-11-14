public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentSystem external;

    public PaymentAdapter(ExternalPaymentSystem external) {
        this.external = external;
    }

    @Override
    public void processPayment(double amount, int method) {
        external.makePayment(amount);
    }
}
