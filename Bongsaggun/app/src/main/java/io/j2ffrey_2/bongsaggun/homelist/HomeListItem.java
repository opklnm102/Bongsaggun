package io.j2ffrey_2.bongsaggun.homelist;

import android.database.Cursor;

import io.j2ffrey_2.bongsaggun.BongsaggunContract;

/**
 * Created by vantovan on 2015. 10. 14..
 */
public class HomeListItem {

    Integer voluntaryId;
    Integer imgSumnail;
    String imgSumnailUrl;
    String title;
    Integer dDay;
    String voluntaryPeriodStart;
    String voluntaryPeriodEnd;
    String voluntaryLocation;
    Integer voluntaryTime;

    public static HomeListItem fromCursor(Cursor cursor) {
        HomeListItem item = new HomeListItem();

        item.voluntaryId = cursor.getInt(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID));
        item.title = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE));
        item.voluntaryLocation = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS));
        item.voluntaryPeriodStart = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_START));
        item.voluntaryPeriodEnd = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_END));
        item.imgSumnailUrl = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL));;
        item.voluntaryTime = Integer.valueOf(cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME)));

        return item;
    }

    public HomeListItem() {
        this.imgSumnail = null;
        this.title = "";
        this.dDay = 0;
        this.voluntaryPeriodStart = "";
        this.voluntaryPeriodEnd = "";
        this.voluntaryLocation = "";
        this.voluntaryTime = 0;
    }

    public HomeListItem(Integer imgSumnail, String title, Integer dDay, String voluntaryPeriodStart, String voluntaryPeriodEnd, String voluntaryLocation, Integer voluntaryTime) {
        this.imgSumnail = imgSumnail;
        this.title = title;
        this.dDay = dDay;
        this.voluntaryPeriodStart = voluntaryPeriodStart;
        this.voluntaryPeriodEnd = voluntaryPeriodEnd;
        this.voluntaryLocation = voluntaryLocation;
        this.voluntaryTime = voluntaryTime;
    }

    public Integer getVoluntaryId() {
        return voluntaryId;
    }

    public void setVoluntaryId(Integer voluntaryId) {
        this.voluntaryId = voluntaryId;
    }

    public String getImgSumnailUrl() {
        return imgSumnailUrl;
    }

    public void setImgSumnailUrl(String imgSumnailUrl) {
        this.imgSumnailUrl = imgSumnailUrl;
    }

    public Integer getImgSumnail() {
        return imgSumnail;
    }

    public void setImgSumnail(Integer imgSumnail) {
        this.imgSumnail = imgSumnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getdDay() {
        return dDay;
    }

    public void setdDay(Integer dDay) {
        this.dDay = dDay;
    }

    public String getVoluntaryPeriodStart() {
        return voluntaryPeriodStart;
    }

    public void setVoluntaryPeriodStart(String voluntaryPeriodStart) {
        this.voluntaryPeriodStart = voluntaryPeriodStart;
    }

    public String getVoluntaryPeriodEnd() {
        return voluntaryPeriodEnd;
    }

    public void setVoluntaryPeriodEnd(String voluntaryPeriodEnd) {
        this.voluntaryPeriodEnd = voluntaryPeriodEnd;
    }

    public String getVoluntaryLocation() {
        return voluntaryLocation;
    }

    public void setVoluntaryLocation(String voluntaryLocation) {
        this.voluntaryLocation = voluntaryLocation;
    }

    public Integer getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(Integer voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }
}
