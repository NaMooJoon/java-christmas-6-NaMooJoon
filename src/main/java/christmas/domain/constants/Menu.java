package christmas.domain.constants;

import static christmas.domain.constants.MenuType.APPETIZERS;
import static christmas.domain.constants.MenuType.BEVERAGES;
import static christmas.domain.constants.MenuType.DESSERTS;
import static christmas.domain.constants.MenuType.MAIN_COURSES;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 6_000, APPETIZERS),
    TAPAS("타파스", 5_500, APPETIZERS),
    CAESAR_SALAD("시저샐러드", 8_000, APPETIZERS),

    T_BONE_STEAK("티본스테이크", 55_000, MAIN_COURSES),
    BARBECUE_RIBS("바비큐립", 54_000, MAIN_COURSES),
    SEAFOOD_PASTA("해산물파스타", 35_000, MAIN_COURSES),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, MAIN_COURSES),

    CHOCOLATE_CAKE("초코케이크", 15_000, DESSERTS),
    ICE_CREAM("아이스크림", 5_000, DESSERTS),

    ZERO_COLA("제로콜라", 3_000, BEVERAGES),
    RED_WINE("레드와인", 60_000, BEVERAGES),
    CHAMPAGNE("샴페인", 25_000, BEVERAGES),
    NONE(null, 0, null);


    private String name;
    private int price;
    private MenuType type;

    Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public static Menu getMenuConstantByName(String name) {
        return Arrays.asList(Menu.values())
                .stream()
                .filter(menu -> name.equals(menu.name))
                .findFirst()
                .orElse(NONE);
    }

    public String getName() {
        return name;
    }
}
