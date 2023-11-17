package christmas.domain;

import static christmas.domain.constants.BenefitType.CHRISTMAS;
import static christmas.domain.constants.BenefitType.SPECIAL_DAY;
import static christmas.domain.constants.BenefitType.WEEKDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitsTest {

    @DisplayName("총혜택 받는 금액 계산 확인")
    @Test
    void 총혜택_계산_확인() {
        List<Benefit> benefitList = new ArrayList<>();
        benefitList.add(Benefit.of(CHRISTMAS, 3_400));
        benefitList.add(Benefit.of(SPECIAL_DAY, 1_000));
        benefitList.add(Benefit.of(WEEKDAY, 2_023));
        Benefits benefits = Benefits.from(benefitList);

        assertThat(benefits.getTotalAmount())
                .isEqualTo(6_423);
    }

    @DisplayName("중복된 할인 예외 처리")
    @Test
    void 중복된_혜택_예외_처리() {
        List<Benefit> benefitList = new ArrayList<>();
        benefitList.add(Benefit.of(CHRISTMAS, 3_400));
        benefitList.add(Benefit.of(SPECIAL_DAY, 1_000));
        benefitList.add(Benefit.of(CHRISTMAS, 10_000));
        benefitList.add(Benefit.of(WEEKDAY, 2_023));

        assertThatThrownBy(() -> Benefits.from(benefitList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}