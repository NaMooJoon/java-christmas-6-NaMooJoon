package christmas.domain;

import static christmas.domain.constants.DateNumber.*;

import christmas.exception.InvalidDateException;

public class Date {
    private int date;

    private Date(int date) {
        validate(date);
        this.date = date;
    }

    public static Date from(int date) {
        return new Date(date);
    }

    public int getDate() {
        return date;
    }

    public boolean isChristmasEventPeriod() {
        return date <= CHRISTMAS_DATE.getDate();
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public boolean isWeekend() {
        if (isFriday() || isSaturday()) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        if (isSunday() || isChristmasDay()) {
            return true;
        }
        return false;
    }

    private void validate(int date) {
        if (isDateOutOfBound(date)) {
            throw new InvalidDateException();
        }
    }

    private boolean isFriday() {
        return (date % DAYS_OF_WEEK_SIZE.getDate()) == FRIDAY_START_DATE_OF_DEC.getDate();
    }

    private boolean isSaturday() {
        return (date % DAYS_OF_WEEK_SIZE.getDate()) == SATDAY_START_DATE_OF_DEC.getDate();
    }

    private boolean isSunday() {
        return (date % DAYS_OF_WEEK_SIZE.getDate()) == SUNDAY_START_DATE_OF_DEC.getDate();
    }

    private boolean isChristmasDay() {
        return date == CHRISTMAS_DATE.getDate();
    }

    private boolean isDateOutOfBound(int date) {
        return date < MIN_DATE_NUMBER.getDate() || date > MAX_DATE_NUMBER.getDate();
    }

    @Override
    public String toString() {
        return String.format("12월 %d일", date);
    }
}
