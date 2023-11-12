package christmas.domain;

import christmas.exception.InvalidOrderException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {
    private List<Order> orders;

    private Orders(List<Order> orders) {
        validateDuplicate(orders);
        this.orders = orders;
    }

    public static Orders from(List<Order> orders) {
        return new Orders(orders);
    }

    private void validateDuplicate(List<Order> orders) {
        boolean hasDuplicate = orders.size() != Set.copyOf(orders).size();
        if (hasDuplicate) {
            throw new InvalidOrderException();
        }
    }

    @Override
    public String toString() {
        return orders.stream()
                .map(Order::toString)
                .collect(Collectors.joining("\n"));
    }
}
