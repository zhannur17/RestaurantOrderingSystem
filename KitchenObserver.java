public class KitchenObserver implements OrderObserver {
    @Override public void update(String status) {
        System.out.println("Kitchen: Your order is " + status);
    }
}
