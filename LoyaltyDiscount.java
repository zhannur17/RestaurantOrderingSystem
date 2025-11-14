import java.util.Scanner;

public class LoyaltyDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter loyalty promo code: ");
        String code = sc.nextLine();
        if (code.equalsIgnoreCase("ilovegszh")) {
            System.out.println("Promo code accepted. 10% discount applied.");
            return amount * 0.9;
        } else {
            System.out.println("Invalid promo code. No discount applied.");
            return amount;
        }
    }
}
