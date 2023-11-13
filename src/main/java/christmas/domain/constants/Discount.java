package christmas.domain.constants;

public enum Discount{
    START_OF_CHRISTMAS_DISCOUNT(1_000),
    ADDITIONAL_CHRISTMAS_DISCOUNT(100),
    WEEKDAY_DISCOUNT(2_023),
    WEEKEND_DISCOUNT(2_023),
    SPECIAL_DAY_DISCOUNT(1_000);



    int amount;
    Discount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
