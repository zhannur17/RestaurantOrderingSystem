import java.time.LocalDate;
import java.time.Month;

public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        Month month = LocalDate.now().getMonth();
        double discount = 0.0;

        if (month == Month.DECEMBER || month == Month.JANUARY || month == Month.FEBRUARY) {

            discount = 0.15;
            System.out.println("Seasonal discount applied: Winter (15%)");
        }
        else if (month == Month.SEPTEMBER || month == Month.OCTOBER || month == Month.NOVEMBER) {
            discount = 0.10;
            System.out.println("Seasonal discount applied: Autumn (10%)");
        }
        else {
            System.out.println("No seasonal discount available for this time of year.");
        }

        return amount * (1 - discount);
    }
}
