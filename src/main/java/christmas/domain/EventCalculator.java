package christmas.domain;

import static christmas.domain.constants.Menu.CHAMPAGNE;

import christmas.domain.constants.Badge;
import christmas.domain.constants.BenefitType;
import java.util.ArrayList;
import java.util.List;

public class EventCalculator {
    private static final int GIFT_EVENT_MINIMUM_AMOUNT = 120_000;
    private final Date date;
    private final Orders orders;

    private EventCalculator(Date date, Orders orders) {
        this.date = date;
        this.orders = orders;
    }

    public static EventCalculator of(Date date, Orders orders) {
        return new EventCalculator(date, orders);
    }


    public Order getEventGift() {
        if (canGetGift()) {
            return Order.of(CHAMPAGNE, 1);
        }
        return null;
    }

    public int getExpectedAmountToPay() {
        Benefits discountBenefits = Benefits.from(getTotalDiscounts());
        return orders.getTotalAmount() - discountBenefits.getTotalAmount();
    }

    public Badge getBadge() {
        int amountOfDiscount = getAllBenefits().getTotalAmount();
        return Badge.getBadgeBy(amountOfDiscount);
    }

    public Benefits getAllBenefits() {
        if (orders.getTotalAmount() < 10_000) {
            return Benefits.from(new ArrayList<>());
        }
        List<Benefit> benefits = getTotalDiscounts();
        if (canGetGift()) {
            benefits.add(Benefit.of(BenefitType.EVENT_GIFT, getEventGift().getPrice()));
        }
        return Benefits.from(benefits);
    }

    private List<Benefit> getTotalDiscounts() {
        List<Benefit> benefits = new ArrayList<>();
        if (date.isChristmasEventPeriod()) {
            benefits.add(Benefit.newChristmas(date));
        }
        if (date.isWeekday()) {
            benefits.add(Benefit.newWeekday(orders.getDessertCount()));
        }
        if (date.isWeekend()) {
            benefits.add(Benefit.newWeekend(orders.getMainCourseCount()));
        }
        if (date.isSpecialDay()) {
            benefits.add(Benefit.newSpecialDay());
        }
        return benefits;
    }

    private boolean canGetGift() {
        return orders.getTotalAmount() >= GIFT_EVENT_MINIMUM_AMOUNT;
    }
}
