import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MealFactory factory = new MealFactory();
        RestaurantFacade restaurant = new RestaurantFacade();
        List<Meal> orderList = new ArrayList<>();

        System.out.println("Welcome to GSZH'S!");
        System.out.println("MAIN MENU");
        System.out.println("Choose items from the menu:");
        System.out.println("1. Pizza");
        System.out.println("2. Burger");
        System.out.println("3. Pasta");
        System.out.println("4. CocaCola");
        System.out.println("5. Fuse Tea");
        System.out.print("Enter your choice (e.g. 1,4,5): ");
        String[] choices = sc.nextLine().split(",");

        for (String choice : choices) {
            int item = Integer.parseInt(choice.trim());
            Meal meal = factory.createMeal(item);
            if (meal == null) continue;

            System.out.print("Enter the quantity for item " + item + ": ");
            int qty = Integer.parseInt(sc.nextLine());

            if (meal instanceof Pizza) {
                System.out.print("Choose pizza size (1. Small, 2. Medium, 3. Large): ");
                int size = Integer.parseInt(sc.nextLine());
                ((Pizza) meal).setSize(size);
                // Decorator pattern
                System.out.println("AVAILABLE EXTRAS (Decorator Pattern):");
                System.out.println("1. Extra Cheese (+$1.50)");
                System.out.println("2. Pepperoni (+$2.00)");
                System.out.println("3. Mushrooms (+$1.50)");
                System.out.println("4. Done selecting extras");
                List<String> extras = new ArrayList<>();
                while (true) {
                    System.out.print("Choose extra (1-4): ");
                    int extra = Integer.parseInt(sc.nextLine());
                    if (extra == 4) break;
                    switch (extra) {
                        case 1 -> { meal = new ExtraCheese(meal); extras.add("extra cheese"); }
                        case 2 -> { meal = new MealDecorator(meal) {
                            @Override public String getDescription() { return meal.getDescription() + ", pepperoni"; }
                            @Override public double getCost() { return meal.getCost() + 2.00; }
                        }; extras.add("pepperoni"); }
                        case 3 -> { meal = new Mushrooms(meal); extras.add("mushrooms"); }
                    }
                    System.out.println("Added " + extras.get(extras.size() - 1));
                    System.out.println("Current extras: " + extras);
                }
                System.out.println("Final extras: " + extras);
            }

            if (meal instanceof CocaCola) {
                System.out.print("Choose CocaCola size (1. 0.5L, 2. 1L): ");
                int size = Integer.parseInt(sc.nextLine());
                ((CocaCola) meal).setSize(size);
            }
            if (meal instanceof FuseTea) {
                System.out.print("Choose FuzeTea size (1. 0.5L, 2. 1L): ");
                int size = Integer.parseInt(sc.nextLine());
                ((FuseTea) meal).setSize(size);
            }

            for (int i = 0; i < qty; i++) orderList.add(meal);
            System.out.println("Item ordered: " + meal.getDescription() + " (x" + qty + ")");
        }

        System.out.println("\nTotal Order List:");
        orderList.forEach(m -> System.out.print(m.getDescription() + ", "));
        double total = orderList.stream().mapToDouble(Meal::getCost).sum();

        // Discount Strategy Pattern
        System.out.println("\nChoose discount type:");
        System.out.println("1. Seasonal");
        System.out.println("2. Loyalty");
        System.out.print("Enter your discount choice (1 or 2): ");
        int discountChoice = Integer.parseInt(sc.nextLine());
        DiscountStrategy discount;

        if (discountChoice == 1) discount = new SeasonalDiscount();
        else discount = new LoyaltyDiscount();

        total = discount.applyDiscount(total);
        System.out.printf("Total cost after discount: $%.2f%n", total);

        // Facade (ordering + payment + observer)
        System.out.println("\nPAYMENT METHOD:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.println("3. Cash");
        System.out.print("Choose payment method: ");
        int paymentMethod = Integer.parseInt(sc.nextLine());
        
        if (paymentMethod == 1) {
            System.out.print("Enter card number: ");
            String cardNumber = sc.nextLine();
            System.out.print("Enter expiry date (MM/YY): ");
            String expiryDate = sc.nextLine();
            System.out.print("Enter CVV: ");
            String cvv = sc.nextLine();

            System.out.println("Credit card payment details received");
        }
        System.out.print("Enter delivery address: ");
        String address = sc.nextLine();

        restaurant.placeOrder(orderList, total, paymentMethod, address);
        sc.close();
    }
}
