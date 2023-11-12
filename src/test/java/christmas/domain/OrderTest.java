package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {
    @DisplayName("고객이 메뉴판에 없는 메뉴를 입력하는 경우, 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"해물파스타", "핫도그"})
    void 없는_메뉴_예외_처리(String name) {
        assertThatThrownBy(() -> Order.nameAndCountOf(name, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("고객이 입력한 메뉴의 개수가 1이상이 아닌 경우, 예외가 발생한다.")
    @Test
    void 메뉴_개수_예외_처리() {
        assertThatThrownBy(() -> Order.nameAndCountOf("해산물파스타", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Order 클래스 생성 정상 확인")
    @ParameterizedTest
    @CsvSource({"양송이수프, 1","시저샐러드, 2", "티본스테이크, 3", "제로콜라, 4"})
    void 메뉴_생성_확인() {

    }
}