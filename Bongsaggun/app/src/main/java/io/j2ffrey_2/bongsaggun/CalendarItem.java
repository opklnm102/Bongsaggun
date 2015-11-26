package io.j2ffrey_2.bongsaggun;

import android.database.Cursor;

/**
 * Created by dong on 2015-10-06.
 */
public class CalendarItem {

    private Integer voluntaryId;
    private String title;
    private Integer dDay;  //현재날짜 - 모집마감
    private String voluntaryRegion;
    private Integer voluntaryTime;
    private String voluntaryDateRecruitStart;
    private String voluntaryDateRecruitEnd;

//    private String voluntaryDateRecruitStartYear;
//    private String voluntaryDateRecruitStartMonth;
//    private String voluntaryDateRecruitStartDay;
//    private String voluntaryDateRecruitStartDayOfWeek;
//
//    private String voluntaryDateRecruitEndYear;
//    private String voluntaryDateRecruitEndMonth;
//    private String voluntaryDateRecruitEndDay;
//    private String voluntaryDateRecruitEndDayOfWeek;

    private String voluntaryDateRecruitYear;
    private String voluntaryDateRecruitMonth;
    private String voluntaryDateRecruitDay;
    private String voluntaryDateRecruitDayOfWeek;

    private boolean status;  //true이면 모집 시작일에 보여주고, false면 모집마감에 보여준다. Todo: 계산


    //Todo: 해당 년,월이면 status에 표시
    public static CalendarItem fromCursor(Cursor cursor) {
        CalendarItem item = new CalendarItem();

        item.voluntaryId = cursor.getInt(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID));
        item.title = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE));
        item.voluntaryDateRecruitStart = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START));
        item.voluntaryDateRecruitEnd = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END));
        item.voluntaryTime = Integer.valueOf(cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME)));
        item.voluntaryRegion = cursor.getString(cursor.getColumnIndex(BongsaggunContract.RegionEntry.COLUMN_REGION_NAME));
        item.dDay = TimeUtils.dateToDday(item.voluntaryDateRecruitEnd);

        item.voluntaryDateRecruitYear = cursor.getString(cursor.getColumnIndex("year"));
        item.voluntaryDateRecruitMonth = cursor.getString(cursor.getColumnIndex("month"));
        item.voluntaryDateRecruitDay = cursor.getString(cursor.getColumnIndex("day"));
        item.voluntaryDateRecruitDayOfWeek = cursor.getString(cursor.getColumnIndex("dayOfWeek"));

        if(item.voluntaryDateRecruitStart.equals(item.voluntaryDateRecruitYear + "-" + item.voluntaryDateRecruitMonth + "-" + item.voluntaryDateRecruitDay)){
            item.status = false;
        }else{
            item.status = true;
        }

        return item;
    }


    public CalendarItem() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getVoluntaryDateRecruitDayOfWeek() {
        return voluntaryDateRecruitDayOfWeek;
    }

    public void setVoluntaryDateRecruitDayOfWeek(String voluntaryDateRecruitDayOfWeek) {
        this.voluntaryDateRecruitDayOfWeek = voluntaryDateRecruitDayOfWeek;
    }

    public String getVoluntaryDateRecruitDay() {
        return voluntaryDateRecruitDay;
    }

    public void setVoluntaryDateRecruitDay(String voluntaryDateRecruitDay) {
        this.voluntaryDateRecruitDay = voluntaryDateRecruitDay;
    }

    public String getVoluntaryDateRecruitMonth() {
        return voluntaryDateRecruitMonth;
    }

    public void setVoluntaryDateRecruitMonth(String voluntaryDateRecruitMonth) {
        this.voluntaryDateRecruitMonth = voluntaryDateRecruitMonth;
    }

    public String getVoluntaryDateRecruitYear() {
        return voluntaryDateRecruitYear;
    }

    public void setVoluntaryDateRecruitYear(String voluntaryDateRecruitYear) {
        this.voluntaryDateRecruitYear = voluntaryDateRecruitYear;
    }

    public String getVoluntaryDateRecruitEnd() {
        return voluntaryDateRecruitEnd;
    }

    public void setVoluntaryDateRecruitEnd(String voluntaryDateRecruitEnd) {
        this.voluntaryDateRecruitEnd = voluntaryDateRecruitEnd;
    }

    public String getVoluntaryDateRecruitStart() {
        return voluntaryDateRecruitStart;
    }

    public void setVoluntaryDateRecruitStart(String voluntaryDateRecruitStart) {
        this.voluntaryDateRecruitStart = voluntaryDateRecruitStart;
    }

    public Integer getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(Integer voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }

    public String getVoluntaryRegion() {
        return voluntaryRegion;
    }

    public void setVoluntaryRegion(String voluntaryRegion) {
        this.voluntaryRegion = voluntaryRegion;
    }

    public Integer getdDay() {
        return dDay;
    }

    public void setdDay(Integer dDay) {
        this.dDay = dDay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVoluntaryId() {
        return voluntaryId;
    }

    public void setVoluntaryId(Integer voluntaryId) {
        this.voluntaryId = voluntaryId;
    }
}
