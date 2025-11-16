import java.util.List;

public class RestaurantFacade {
    public void placeOrder(List<Meal> meals, double total, int paymentMethod, String address) {
        OrderSubject order = new OrderSubject();
        OrderObserver customer = new CustomerObserver();
        OrderObserver kitchen = new KitchenObserver();
        order.addObserver(customer);
        order.addObserver(kitchen);

        order.setStatus("created");
        order.setStatus("preparing");
        order.setStatus("ready");
        order.setStatus("with the courier");

        PaymentProcessor payment = new PaymentAdapter(new ExternalPaymentSystem());
        
        payment.processPayment(total, paymentMethod, "", "", "");

        System.out.println("Thank you for choosing GSZH'S!");
    }
}

