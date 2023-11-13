package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventCalculatorTest {
    EventCalculator eventCalculator;
    @BeforeEach
    void setUp() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(Order.of("티본스테이크", 1));
        orderList.add(Order.of("바비큐립", 1));
        orderList.add(Order.of("초코케이크", 2));
        orderList.add(Order.of("제로콜라", 1));

        eventCalculator = EventCalculator.of(Date.from(3), Orders.from(orderList));
    }

    @DisplayName("증정 메뉴를 확인한다.")
    @Test
    void 증정_메뉴_확인() {
        Order gift = eventCalculator.getEventGift();
        assertThat(gift.toString())
                .isEqualTo("샴페인 1개");
    }

    @DisplayName("혜택 내역을 확인한다.")
    @Test
    void 혜택_내역_확인() {
        Benefits benefits = eventCalculator.getAllBenefits();
        assertThat(benefits.toString())
                .isEqualTo("크리스마스 디데이 할인: -1,200원\n"
                        + "평일 할인: -4,046원\n"
                        + "특별 할인: -1,000원\n"
                        + "증정 이벤트: -25,000원");
    }

    @DisplayName("총혜택 금액을 확인한다.")
    @Test
    void 총혜택_금액_확인() {
        Benefits benefits = eventCalculator.getAllBenefits();
        int total = benefits.getTotalAmount();

        assertThat(total)
                .isEqualTo(31_246);
    }

}