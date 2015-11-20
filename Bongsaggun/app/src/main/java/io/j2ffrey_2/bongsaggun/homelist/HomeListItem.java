package io.j2ffrey_2.bongsaggun.homelist;

import android.database.Cursor;

import io.j2ffrey_2.bongsaggun.BongsaggunContract;
import io.j2ffrey_2.bongsaggun.TimeUtils;

/**
 * Created by vantovan on 2015. 10. 14..
 */
public class HomeListItem {

    private Integer voluntaryId;
    private Integer imgSumnail;
    private String imgSumnailUrl;
    private String title;
    private Integer dDay;
    private String voluntaryDateRecruitStart;
    private String voluntaryDateRecruitEnd;
    private String voluntaryRegion;
    private Integer voluntaryTime;

    public static HomeListItem fromCursor(Cursor cursor) {
        HomeListItem item = new HomeListItem();

        item.voluntaryId = cursor.getInt(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID));
        item.title = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE));
        item.voluntaryDateRecruitStart = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START));
        item.voluntaryDateRecruitEnd = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END));
        item.imgSumnailUrl = cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL));;
        item.voluntaryTime = Integer.valueOf(cursor.getString(cursor.getColumnIndex(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME)));
        item.voluntaryRegion = cursor.getString(cursor.getColumnIndex(BongsaggunContract.RegionEntry.COLUMN_REGION_NAME));
        item.dDay = TimeUtils.dateToDday(item.voluntaryDateRecruitEnd);

        return item;
    }

    public HomeListItem() {
        this.imgSumnail = null;
        this.title = "";
        this.dDay = 0;
        this.voluntaryDateRecruitStart = "";
        this.voluntaryDateRecruitEnd = "";
        this.voluntaryRegion = "";
        this.voluntaryTime = 0;
    }

    public HomeListItem(Integer imgSumnail, String title, Integer dDay, String voluntaryDateRecruitStart, String voluntaryDateRecruitEnd, String voluntaryRegion, Integer voluntaryTime) {
        this.imgSumnail = imgSumnail;
        this.title = title;
        this.dDay = dDay;
        this.voluntaryDateRecruitStart = voluntaryDateRecruitStart;
        this.voluntaryDateRecruitEnd = voluntaryDateRecruitEnd;
        this.voluntaryRegion = voluntaryRegion;
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
}
