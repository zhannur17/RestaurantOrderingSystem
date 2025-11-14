public class ExtraCheese extends MealDecorator {
    public ExtraCheese(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + ", extra cheese"; }
    @Override public double getCost() { return meal.getCost() + 1.5; }
}
