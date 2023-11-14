package christmas.domain;

import static christmas.domain.constants.BenefitType.CHRISTMAS;
import static christmas.domain.constants.BenefitType.SPECIAL_DAY;
import static christmas.domain.constants.BenefitType.WEEKDAY;
import static christmas.domain.constants.BenefitType.WEEKEND;
import static christmas.domain.constants.DiscountAmount.ADDITIONAL_CHRISTMAS_DISCOUNT;
import static christmas.domain.constants.DiscountAmount.SPECIAL_DAY_DISCOUNT;
import static christmas.domain.constants.DiscountAmount.START_OF_CHRISTMAS_DISCOUNT;
import static christmas.domain.constants.DiscountAmount.WEEKDAY_DISCOUNT;
import static christmas.domain.constants.DiscountAmount.WEEKEND_DISCOUNT;

import christmas.domain.constants.BenefitType;
import java.util.Locale;
import java.util.Objects;

public class Benefit {
    private final BenefitType type;
    private final int amount;

    private Benefit(BenefitType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public static Benefit of(BenefitType type, int amount) {
        return new Benefit(type, amount);
    }

    public static Benefit newChristmas(Date date) {
        int amount = START_OF_CHRISTMAS_DISCOUNT.getAmount()
                + (ADDITIONAL_CHRISTMAS_DISCOUNT.getAmount() * (date.getDate() - 1));
        return new Benefit(CHRISTMAS, amount);
    }

    public static Benefit newWeekday(int desertCount) {
        int amount = WEEKDAY_DISCOUNT.getAmount() * desertCount;
        return new Benefit(WEEKDAY, amount);
    }

    public static Benefit newWeekend(int mainCourseCount) {
        int amount = WEEKEND_DISCOUNT.getAmount() * mainCourseCount;
        return new Benefit(WEEKEND, amount);
    }

    public static Benefit newSpecialDay() {
        return new Benefit(SPECIAL_DAY, SPECIAL_DAY_DISCOUNT.getAmount());
    }

    public BenefitType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        String formattedAmount = String.format(Locale.KOREA, "%,d원", amount);
        return String.format("%s: -%s", type.getDiscountName(), formattedAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Benefit benefit = (Benefit) o;
        return type == benefit.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
