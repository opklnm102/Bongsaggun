package io.j2ffrey_2.bongsaggun;

/**
 * Created by User on 2015-10-07.
 */
public class CalendarHeaderItem {

    private String month;
    private String dayOfWeek;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public CalendarHeaderItem(String month, String dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public CalendarHeaderItem() {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }
}
