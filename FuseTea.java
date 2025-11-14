public class FuseTea extends Meal {
    private String size = "0.5L";
    private double cost = 1.5;
    public void setSize(int choice) {
        if (choice == 2) { size = "1L"; cost = 2.5; }
    }
    @Override public String getDescription() { return "Fuze Tea (" + size + ")"; }
    @Override public double getCost() { return cost; }
}
