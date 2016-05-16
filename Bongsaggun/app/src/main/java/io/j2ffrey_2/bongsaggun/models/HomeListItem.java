package io.j2ffrey_2.bongsaggun.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vantovan on 2015. 10. 14..
 */
public class HomeListItem {

    //Todo: 보여줘야 할것, 메인이미지, 제목, 모집기간 시작, 종료, 봉사시간, 지역, D-day

    @SerializedName("id")
    private Integer voluntaryId;
    @SerializedName("img_main_url")
    String imgMainUrl;
    @SerializedName("name")
    String title;
    @SerializedName("d_day")
    int dDay;
    @SerializedName("date_recruit_start")
    String voluntaryDateRecruitStart;
    @SerializedName("date_recruit_end")
    String voluntaryDateRecruitEnd;
    String region;
    @SerializedName("time_expect_total")
    int voluntaryTime;

    public Integer getVoluntaryId() {
        return voluntaryId;
    }

    public void setVoluntaryId(Integer voluntaryId) {
        this.voluntaryId = voluntaryId;
    }

    public String getImgMainUrl() {
        return imgMainUrl;
    }

    public void setImgMainUrl(String imgMainUrl) {
        this.imgMainUrl = imgMainUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getdDay() {
        return dDay;
    }

    public void setdDay(int dDay) {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(int voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }

    public HomeListItem(Integer voluntaryId, String imgMainUrl, String title, int dDay, String voluntaryDateRecruitStart, String voluntaryDateRecruitEnd, String region, int voluntaryTime) {
        this.voluntaryId = voluntaryId;
        this.imgMainUrl = imgMainUrl;
        this.title = title;
        this.dDay = dDay;
        this.voluntaryDateRecruitStart = voluntaryDateRecruitStart;
        this.voluntaryDateRecruitEnd = voluntaryDateRecruitEnd;
        this.region = region;
        this.voluntaryTime = voluntaryTime;
    }

    public HomeListItem() {
    }

}
