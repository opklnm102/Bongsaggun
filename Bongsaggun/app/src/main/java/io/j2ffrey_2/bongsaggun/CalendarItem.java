package io.j2ffrey_2.bongsaggun;

import android.database.Cursor;

/**
 * Created by dong on 2015-10-06.
 */
public class CalendarItem {

    private Integer voluntaryId;
    private String title;
    private String dDay;  //현재날짜 - 모집마감
    private String voluntaryRegion;
    private Integer voluntaryTime;
    private String voluntaryDateRecruitStart;
    private String voluntaryDateRecruitEnd;
    private String voluntaryDateRecruitStartYear;
    private String voluntaryDateRecruitStartMonth;
    private String voluntaryDateRecruitEndYear;
    private String voluntaryDateRecruitEndMonth;
    private String dayOfWeek;  //Todo: 날짜로 요일 계산
    private boolean status;  //true이면 모집 시작일에 보여주고, false면 모집마감에 보여준다.

    public static CalendarItem fromCursor(Cursor cursor) {
        CalendarItem item = new CalendarItem();






        return item;
    }

    public CalendarItem(Integer voluntaryId, String title, String dDay, String voluntaryRegion, Integer voluntaryTime, String voluntaryDateRecruitStart, String voluntaryDateRecruitEnd, String voluntaryDateRecruitStartYear, String voluntaryDateRecruitStartMonth, String voluntaryDateRecruitEndYear, String voluntaryDateRecruitEndMonth, String dayOfWeek, boolean status) {
        this.voluntaryId = voluntaryId;
        this.title = title;
        this.dDay = dDay;
        this.voluntaryRegion = voluntaryRegion;
        this.voluntaryTime = voluntaryTime;
        this.voluntaryDateRecruitStart = voluntaryDateRecruitStart;
        this.voluntaryDateRecruitEnd = voluntaryDateRecruitEnd;
        this.voluntaryDateRecruitStartYear = voluntaryDateRecruitStartYear;
        this.voluntaryDateRecruitStartMonth = voluntaryDateRecruitStartMonth;
        this.voluntaryDateRecruitEndYear = voluntaryDateRecruitEndYear;
        this.voluntaryDateRecruitEndMonth = voluntaryDateRecruitEndMonth;
        this.dayOfWeek = dayOfWeek;
        this.status = status;
    }

    public CalendarItem() {
        this.voluntaryId = 0;
        this.title = "";
        this.dDay = "";
        this.voluntaryRegion = "";
        this.voluntaryTime = 0;
        this.voluntaryDateRecruitStart = "";
        this.voluntaryDateRecruitEnd = "";
        this.voluntaryDateRecruitStartYear = "";
        this.voluntaryDateRecruitStartMonth = "";
        this.voluntaryDateRecruitEndYear = "";
        this.voluntaryDateRecruitEndMonth = "";
        this.dayOfWeek = "";
        this.status = false;
    }

    public Integer getVoluntaryId() {
        return voluntaryId;
    }

    public void setVoluntaryId(Integer voluntaryId) {
        this.voluntaryId = voluntaryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getdDay() {
        return dDay;
    }

    public void setdDay(String dDay) {
        this.dDay = dDay;
    }

    public String getVoluntaryRegion() {
        return voluntaryRegion;
    }

    public void setVoluntaryRegion(String voluntaryRegion) {
        this.voluntaryRegion = voluntaryRegion;
    }

    public Integer getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(Integer voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }

    public String getVoluntaryDateRecruitStart() {
        return voluntaryDateRecruitStart;
    }

    public void setVoluntaryDateRecruitStart(String voluntaryDateRecruitStart) {
        this.voluntaryDateRecruitStart = voluntaryDateRecruitStart;
    }

    public String getVoluntaryDateRecruitEnd() {
        return voluntaryDateRecruitEnd;
    }

    public void setVoluntaryDateRecruitEnd(String voluntaryDateRecruitEnd) {
        this.voluntaryDateRecruitEnd = voluntaryDateRecruitEnd;
    }

    public String getVoluntaryDateRecruitStartYear() {
        return voluntaryDateRecruitStartYear;
    }

    public void setVoluntaryDateRecruitStartYear(String voluntaryDateRecruitStartYear) {
        this.voluntaryDateRecruitStartYear = voluntaryDateRecruitStartYear;
    }

    public String getVoluntaryDateRecruitStartMonth() {
        return voluntaryDateRecruitStartMonth;
    }

    public void setVoluntaryDateRecruitStartMonth(String voluntaryDateRecruitStartMonth) {
        this.voluntaryDateRecruitStartMonth = voluntaryDateRecruitStartMonth;
    }

    public String getVoluntaryDateRecruitEndYear() {
        return voluntaryDateRecruitEndYear;
    }

    public void setVoluntaryDateRecruitEndYear(String voluntaryDateRecruitEndYear) {
        this.voluntaryDateRecruitEndYear = voluntaryDateRecruitEndYear;
    }

    public String getVoluntaryDateRecruitEndMonth() {
        return voluntaryDateRecruitEndMonth;
    }

    public void setVoluntaryDateRecruitEndMonth(String voluntaryDateRecruitEndMonth) {
        this.voluntaryDateRecruitEndMonth = voluntaryDateRecruitEndMonth;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
