public class Mushrooms extends MealDecorator {
    public Mushrooms(Meal meal) { super(meal); }
    @Override public String getDescription() { return meal.getDescription() + ", mushrooms"; }
    @Override public double getCost() { return meal.getCost() + 1.5; }
}
