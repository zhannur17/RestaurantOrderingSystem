public class CustomerObserver implements OrderObserver {
    @Override public void update(String status) {
        System.out.println("Customer: Your order is " + status);
    }
}
