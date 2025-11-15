public class ExternalPaymentSystem {
    public void processCreditCard(double amount, String cardNumber, String expiry, String cvv) {
        String lastFour = cardNumber.length() > 4 ? cardNumber.substring(cardNumber.length() - 4) : cardNumber;
        System.out.println("💳 Credit card payment: $" + amount);
        System.out.println("   Card: ****" + lastFour + ", Expiry: " + expiry + ", CVV: ***");
        System.out.println("  Payment approved via bank gateway");
    }
    public void processPayPal(double amount) {
        System.out.println("📧 PayPal payment: $" + amount);
        System.out.println("Redirecting to PayPal secure login...");
        System.out.println("Payment completed via PayPal");
    }
    public void processCash(double amount) {
        System.out.println("Cash payment: $" + amount);
        System.out.println(" Please prepare exact amount for delivery");
        System.out.println("Cash payment registered");
    }
}
