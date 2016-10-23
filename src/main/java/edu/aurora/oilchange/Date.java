package edu.aurora.oilchange;

import java.time.LocalDate;

/**
 * A date with month, day, and year.
 */
public class Date {
    public static final int MAX_MONTH = 12;
    public static final int MAX_DAY = 31;

    /** The month of the year, from 1 (January) to 12 (December) */
    private int month;

    /** The day of the month, from 1 to, maximally, 31 */
    private int day;

    /** The year */
    private int year;

    /**
     * Creates a new date from today's date.
     */
    public Date() {
        LocalDate today = LocalDate.now();
        this.month = today.getMonthValue();
        this.day = today.getDayOfMonth();
        this.year = today.getYear();
    }

    /**
     * Creates a new date from the supplied fields.
     *
     * @param month the month of the year
     * @param day the day of the month
     * @param year the year
     */
    public Date(int month, int day, int year) {
        // these are already validated before they get to us,
        // but just to be safe we'll do some basic bounds checking
        if (month < 0 || month > MAX_MONTH) {
            throw new InvalidDateException("The month must be between 1 and 12");
        } else if (day < 0 || day > MAX_DAY) {
            throw new InvalidDateException("The day must be between 1 and 31");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 0 || month > MAX_MONTH) {
            throw new InvalidDateException("The month must be between 1 and 12");
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        // again, minimal bounds checking (this should be validated already)
        if (day < 0 || day > MAX_DAY) {
            throw new InvalidDateException("The day must be between 1 and 31");
        }
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Returns a string representation of the date, in the format yyyy-mm-dd
     * @return the date in the format yyyy-mm-dd
     */
    @Override
    public String toString() {
        return String.format("%d-%2d-%2d", year, month, day);
    }
}
