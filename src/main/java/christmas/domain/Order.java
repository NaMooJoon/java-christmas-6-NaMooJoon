package christmas.domain;

import static christmas.domain.constants.Menu.NONE;

import christmas.domain.constants.Menu;
import christmas.exception.InvalidOrderException;
import java.util.Map;
import java.util.Objects;

public class Order {
    private static final int MINIMUM_ORDER_COUNT = 1;

    private Menu menu;
    private int count;

    private Order(Menu menu, int count) {
        validate(menu, count);
        this.menu = menu;
        this.count = count;
    }

    public static Order menuAndCountOf(Menu menu, int count) {
        return new Order(menu, count);
    }

    public static Order nameAndCountOf(String name, int count) {
        Menu menu = Menu.getMenuConstantByName(name);
        return new Order(menu, count);
    }

    private void validate(Menu menu, int count) {
        if (menu == NONE) {
            throw new InvalidOrderException();
        }
        if (count < MINIMUM_ORDER_COUNT) {
            throw new InvalidOrderException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return menu == order.menu;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return String.format("%s %s개", menu.getName(), count);
    }
}
