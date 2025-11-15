public class PaymentAdapter implements PaymentProcessor {
    private ExternalPaymentSystem external;
    public PaymentAdapter(ExternalPaymentSystem external) {
        this.external = external;
    }
    @Override
    public void processPayment(double amount, int method, String cardNumber, String expiry, String cvv) {
        switch (method) {
            case 1: // Credit Card
                external.processCreditCard(amount, cardNumber, expiry, cvv);
                break;
            case 2: // PayPal
                external.processPayPal(amount);
                break;
            case 3: // Cash
                external.processCash(amount);
                break;
            default:
                System.out.println("❌ Unknown payment method");
        }
    }
}
