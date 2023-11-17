package christmas.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Benefits {
    private final List<Benefit> benefits;

    private Benefits(List<Benefit> benefits) {
        validateDuplicate(benefits);
        this.benefits = benefits;
    }

    public static Benefits from(List<Benefit> benefits) {
        return new Benefits(benefits);
    }

    public int getTotalAmount() {
        return benefits.stream()
                .mapToInt(Benefit::getAmount)
                .sum();
    }

    public boolean isEmpty() {
        return benefits.isEmpty();
    }

    private void validateDuplicate(List<Benefit> benefits) {
        boolean hasDuplicate = benefits.size() != Set.copyOf(benefits).size();
        if (hasDuplicate) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        if (benefits.isEmpty()) {
            return "없음";
        }
        return benefits.stream()
                .map(Benefit::toString)
                .collect(Collectors.joining("\n"));
    }
}
