package christmas.domain;

import static christmas.domain.constants.BenefitType.CHRISTMAS;
import static christmas.domain.constants.BenefitType.SPECIAL_DAY;
import static christmas.domain.constants.BenefitType.WEEKDAY;
import static christmas.domain.constants.BenefitType.WEEKEND;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.constants.BenefitType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitTest {

    @DisplayName("크리스마스 혜택을 생성한다.")
    @Test
    void newChristmas() {
        Benefit benefit = Benefit.newChristmas(Date.from(25));
        assertThat(benefit.getType())
                .isEqualTo(CHRISTMAS);
        assertThat(benefit.getAmount())
                .isEqualTo(3_400);
    }

    @DisplayName("평일 혜택을 생성한다.")
    @Test
    void newWeekday() {
        Benefit benefit = Benefit.newWeekday(2);
        assertThat(benefit.getType())
                .isEqualTo(WEEKDAY);
        assertThat(benefit.getAmount())
                .isEqualTo(4_046);
    }

    @DisplayName("주말 혜택을 생성한다.")
    @Test
    void newWeekend() {
        Benefit benefit = Benefit.newWeekend(2);
        assertThat(benefit.getType())
                .isEqualTo(WEEKEND);
        assertThat(benefit.getAmount())
                .isEqualTo(4_046);
    }

    @DisplayName("특별 혜택을 생성한다.")
    @Test
    void newSpecialDay() {
        Benefit benefit = Benefit.newSpecialDay();
        assertThat(benefit.getType())
                .isEqualTo(SPECIAL_DAY);
        assertThat(benefit.getAmount())
                .isEqualTo(1_000);
    }
}