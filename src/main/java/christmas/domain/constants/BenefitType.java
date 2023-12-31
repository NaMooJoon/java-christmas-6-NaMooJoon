package christmas.domain.constants;

public enum BenefitType {
    CHRISTMAS("크리스마스 디데이 할인"),
    WEEKDAY("평일 할인"),
    WEEKEND("주말 할인"),
    SPECIAL_DAY("특별 할인"),
    EVENT_GIFT("증정 이벤트");

    private final String discountName;

    BenefitType(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountName() {
        return discountName;
    }

}
