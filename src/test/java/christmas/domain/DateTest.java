package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DateTest {
    @DisplayName("예상 방문 날짜가 1이상 31 이하의 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "32"})
    void 예상_방문_날짜_예외_처리_확인(int number) {
        assertThatThrownBy(() -> Date.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특별 할인 해당 날짜를 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource({"3", "10", "17", "24", "25", "31"})
    void 특별_할인_해당_날짜_확인(int number) {
        Date date = Date.of(number);
        assertThat(date.isSpecialDay() == true);
    }

    @DisplayName("주말을 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource({"8", "16", "22", "30"})
    void 주말_날짜_확인(int number) {
        Date date = Date.of(number);
        assertThat(date.isWeekend() == true);
    }

}