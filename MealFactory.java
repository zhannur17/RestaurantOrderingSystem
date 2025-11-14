public class MealFactory {
    public Meal createMeal(int choice) {
        return switch (choice) {
            case 1 -> new Pizza();
            case 2 -> new Burger();
            case 3 -> new Pasta();
            case 4 -> new CocaCola();
            case 5 -> new FuseTea();
            default -> null;
        };
    }
}
