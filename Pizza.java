public class Pizza extends Meal {
    private String size = "Medium";
    private double cost = 6.0;

    public void setSize(int choice) {
        switch (choice) {
            case 1 -> { size = "Small"; cost = 4.5; }
            case 2 -> { size = "Medium"; cost = 6.0; }
            case 3 -> { size = "Large"; cost = 8.0; }
        }
    }

    @Override public String getDescription() { return "Pizza (" + size + ")"; }
    @Override public double getCost() { return cost; }
}
