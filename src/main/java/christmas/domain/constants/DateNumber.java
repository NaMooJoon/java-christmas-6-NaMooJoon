package christmas.domain.constants;

public enum DateNumber {
    MIN_DATE_NUMBER(1),
    MAX_DATE_NUMBER(31),

    DAYS_OF_WEEK_SIZE(7),
    FRIDAY_START_DATE_OF_DEC(1),
    SATDAY_START_DATE_OF_DEC(2),
    SUNDAY_START_DATE_OF_DEC(3),
    CHRISTMAS_DATE(25);

    private final int date;

    DateNumber(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }
}
