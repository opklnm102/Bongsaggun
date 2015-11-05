package io.j2ffrey_2.bongsaggun;

/**
 * Created by dong on 2015-10-06.
 */
public class VoluntaryWork {

    private String year;
    private String month;
    private String day;
    private String dayOfWeek;
    private boolean state;
    private String dDay;
    private String title;
    private String location;
    private String time;

    public VoluntaryWork() {
        this.year = "";
        this.month = "";
        this.day = "";
        this.dayOfWeek = "";
        this.state = false;
        this.dDay = "";
        this.title = "";
        this.location = "";
        this.time = "";
    }

    public VoluntaryWork(String year, String month, String day, String dayOfWeek, boolean state, String dDay, String title, String location, String time) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.state = state;
        this.dDay = dDay;
        this.title = title;
        this.location = location;
        this.time = time;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getdDay() {
        return dDay;
    }

    public void setdDay(String dDay) {
        this.dDay = dDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
