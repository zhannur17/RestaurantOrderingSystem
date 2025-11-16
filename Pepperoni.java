public class Pepperoni extends MealDecorator { 
    public Pepperoni(Meal meal) { super(meal); } 
    @Override public String getDescription() { return meal.getDescription() + ", pepperoni"; } 
    @Override public double getCost() { return meal.getCost() + 2.0; } 
}
