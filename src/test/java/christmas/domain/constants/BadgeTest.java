package christmas.domain.constants;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {

    @DisplayName("가격에 따른 적절한 배지를 판단한다.")
    @Test
    void 적절한_배지_유추_확인() {
        assertThat(Badge.getBadgeBy(1_000))
                .isEqualTo(Badge.NONE);

        assertThat(Badge.getBadgeBy(5_000))
                .isEqualTo(Badge.STAR);

        assertThat(Badge.getBadgeBy(10_000))
                .isEqualTo(Badge.TREE);

        assertThat(Badge.getBadgeBy(20_000))
                .isEqualTo(Badge.SANTA);
    }

}