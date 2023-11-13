package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrdersTest {
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