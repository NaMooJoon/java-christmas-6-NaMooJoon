package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
    private List<String> menuNames;

    @BeforeEach
    void setUp() {
        menuNames = Arrays.asList(
                "시저샐러드", "티본스테이크", "바비큐립",
                "해산물파스타", "초코케이크", "아이스크림", "샴페인");
    }

    @DisplayName("주문 중 디저트의 개수를 확인할 수 있다.")
    @Test
    void 디저트_개수_확인() {
        List<Order> orderList = menuNames.stream()
                .map(name -> Order.of(name, 2))
                .collect(Collectors.toList());

        Orders orders = Orders.from(orderList);
        assertThat(orders.getDessertCount())
                .isEqualTo(4);
    }

    @DisplayName("주문 중 메인 메뉴의 개수를 확인할 수 있다.")
    @Test
    void 메인_메뉴_개수_확인() {
        List<Order> orderList = menuNames.stream()
                .map(name -> Order.of(name, 2))
                .collect(Collectors.toList());

        Orders orders = Orders.from(orderList);
        assertThat(orders.getMainCourseCount())
                .isEqualTo(6);
    }

    @DisplayName("메뉴의 개수는 20개 이하이다.")
    @Test
    void 메뉴_개수_20개_초과_예외_처리() {
        List<Order> orderList = menuNames.stream()
                .map(name -> Order.of(name, 3))
                .collect(Collectors.toList());

        assertThatThrownBy(() -> Orders.from(orderList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴는 음료수만 주문 할 수 없다.")
    @Test
    void 음료수만_주문_예외_처리() {
        List<String> names = Arrays.asList("제로콜라, 레드와인, 샴페인");
        List<Order> orders = names.stream()
                .map(name -> Order.of(name, 1))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> Orders.from(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 입력하는 경우, 예외 처리 한다.")
    @Test
    void 중복_메뉴_예외_처리() {
        List<String> names = Arrays.asList("티본스테이크", "바비큐립", "초코케이크", "티본스테이크");
        List<Order> orders = names.stream()
                .map(name -> Order.of(name, 1))
                .collect(Collectors.toList());
        assertThatThrownBy(() -> Orders.from(orders))
                .isInstanceOf(IllegalArgumentException.class);
    }

}