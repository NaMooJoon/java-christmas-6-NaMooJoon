package christmas.domain;

import christmas.exception.InvalidDateException;

public class Date {
    private static final int MIN_DATE_NUMBER = 1;
    private static final int MAX_DATE_NUMBER = 31;

    private static final int DAYS_OF_WEEK_SIZE = 7;
    private static final int FRIDAY_START_DATE_OF_DEC = 1;
    private static final int SATDAY_START_DATE_OF_DEC = 2;
    private static final int SUNDAY_START_DATE_OF_DEC = 3;
    private static final int CHRISTMAS_DATE = 25;

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

    public boolean isChristmas() {
        return date <= CHRISTMAS_DATE;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public boolean isWeekend() {
        if (date % DAYS_OF_WEEK_SIZE == FRIDAY_START_DATE_OF_DEC) {
            return true;
        }
        if (date % DAYS_OF_WEEK_SIZE == SATDAY_START_DATE_OF_DEC) {
            return true;
        }
        return false;
    }

    public boolean isSpecialDay() {
        if (date % DAYS_OF_WEEK_SIZE == SUNDAY_START_DATE_OF_DEC) {
            return true;
        }
        if (date == CHRISTMAS_DATE) {
            return true;
        }
        return false;
    }

    private void validate(int date) {
        if (date < MIN_DATE_NUMBER) {
            throw new InvalidDateException();
        }
        if (date > MAX_DATE_NUMBER) {
            throw new InvalidDateException();
        }
    }

    @Override
    public String toString() {
        return String.format("12월 %d일", date);
    }
}
