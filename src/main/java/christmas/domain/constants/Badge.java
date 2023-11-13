package christmas.domain.constants;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Badge {
    NONE("없음", (benefits) -> {
        return benefits < 5_000;
    }),
    STAR("별", (benefits) -> {
        return (5_000 <= benefits && benefits < 10_000);
    }),
    TREE("트리", (benefits) -> {
        return (10_000 <= benefits && benefits < 20_000);
    }),
    SANTA("산타", (benefits) -> {
        return benefits >= 20_000;
    });

    private String name;
    private Predicate<Integer> isMatched;
    Badge(String name, Predicate<Integer> isMatched) {
        this.name = name;
        this.isMatched = isMatched;
    }

    public String getName() {
        return name;
    }

    public static Badge getBadgeBy(int amount) {
        return Arrays.asList(Badge.values())
                .stream()
                .filter(badge -> badge.isMatched.test(amount))
                .findAny()
                .orElse(NONE);
    }

}
