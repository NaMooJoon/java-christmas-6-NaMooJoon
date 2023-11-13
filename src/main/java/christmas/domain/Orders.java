package christmas.domain;

import static christmas.domain.constants.Menu.CHAMPAGNE;
import static christmas.domain.constants.MenuType.BEVERAGES;
import static christmas.domain.constants.MenuType.DESSERTS;
import static christmas.domain.constants.MenuType.MAIN_COURSES;

import christmas.exception.InvalidOrderException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {
    private static final int MAX_ORDERS_NUMBER = 20;
    private List<Order> orders;

    private Orders(List<Order> orders) {
        validateSize(orders);
        validateDuplicate(orders);
        validateNotOnlyBeverage(orders);
        this.orders = orders;
    }

    public static Orders from(List<Order> orders) {
        return new Orders(orders);
    }

    public int getTotalAmount() {
        return orders.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }

    public int getDesertCount() {
        return orders.stream()
                .filter(order -> order.isTypeOf(DESSERTS))
                .mapToInt(Order::getCount)
                .sum();
    }

    public int getMainCourseCount() {
        return orders.stream()
                .filter(order -> order.isTypeOf(MAIN_COURSES))
                .mapToInt(Order::getCount)
                .sum();
    }

    private void validateSize(List<Order> orders) {
        if (orders.size() > MAX_ORDERS_NUMBER) {
            throw new InvalidOrderException();
        }
    }

    private void validateDuplicate(List<Order> orders) {
        boolean hasDuplicate = orders.size() != Set.copyOf(orders).size();
        if (hasDuplicate) {
            throw new InvalidOrderException();
        }
    }

    private void validateNotOnlyBeverage(List<Order> orders) {
        int beverageCount = (int) orders.stream()
                .filter(order -> order.isTypeOf(BEVERAGES))
                .count();

        boolean onlyBeverage = orders.size() == beverageCount;
        if (onlyBeverage) {
            throw new InvalidOrderException();
        }
    }

    @Override
    public String toString() {
        if (orders.isEmpty()) {
            return "없음\n";
        }
        return orders.stream()
                .map(Order::toString)
                .collect(Collectors.joining("\n"));
    }

}
