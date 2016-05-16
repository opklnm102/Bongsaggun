package io.j2ffrey_2.bongsaggun.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dong on 2015-12-03.
 */
public class InfoItem {

    //Todo: 보여줘야 할것
    /*
    메인이미지, 포스터이미지, 제목, 모집기간 시작, 종료, 봉사기간 시작, 종료, 봉사시간, 주소
    지역, 기관, D-day, 인증서 여부
     */

    @SerializedName("id")
    private Integer voluntaryId;

    @SerializedName("name")
    String title;

    @SerializedName("date_recruit_start")
    String voluntaryDateRecruitStart;

    @SerializedName("date_recruit_end")
    String voluntaryDateRecruitEnd;

    @SerializedName("date_real_start")
    String voluntaryDateRealStart;

    @SerializedName("date_real_end")
    String voluntaryDateRealEnd;

    @SerializedName("time_expect_total")
    int voluntaryTime;

    String address;

    @SerializedName("is_approval")
    boolean approval;

    @SerializedName("img_main")
    String imgMainUrl;

    @SerializedName("img_poster")
    String imgPosterUrl;

    String link;

    @SerializedName("vltr_req")
    String requirement;

    @SerializedName("vltr_num")
    int currentRecruit;

    @SerializedName("vltr_num2")
    int totalRecruit;

    @SerializedName("clerk_name")
    String clerkName;

    @SerializedName("clerk_call")
    String clerkCall;

    @SerializedName("clerk_email")
    String clerkEmail;

    @SerializedName("clerk_link")
    String clerkLink;

    @SerializedName("dday")
    int dDay;

    String status;

    String incentive;

    @SerializedName("content_etc")
    String contents;

    String organization;
    String region;
    String school;
    String category;

    public int getdDay() {
        return dDay;
    }

    public void setdDay(int dDay) {
        this.dDay = dDay;
    }

    String btime;


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

    public String getVoluntaryDateRealStart() {
        return voluntaryDateRealStart;
    }

    public void setVoluntaryDateRealStart(String voluntaryDateRealStart) {
        this.voluntaryDateRealStart = voluntaryDateRealStart;
    }

    public String getVoluntaryDateRealEnd() {
        return voluntaryDateRealEnd;
    }

    public void setVoluntaryDateRealEnd(String voluntaryDateRealEnd) {
        this.voluntaryDateRealEnd = voluntaryDateRealEnd;
    }

    public int getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(int voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    public String getImgMainUrl() {
        return imgMainUrl;
    }

    public void setImgMainUrl(String imgMainUrl) {
        this.imgMainUrl = imgMainUrl;
    }

    public String getImgPosterUrl() {
        return imgPosterUrl;
    }

    public void setImgPosterUrl(String imgPosterUrl) {
        this.imgPosterUrl = imgPosterUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getCurrentRecruit() {
        return currentRecruit;
    }

    public void setCurrentRecruit(int currentRecruit) {
        this.currentRecruit = currentRecruit;
    }

    public int getTotalRecruit() {
        return totalRecruit;
    }

    public void setTotalRecruit(int totalRecruit) {
        this.totalRecruit = totalRecruit;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getClerkCall() {
        return clerkCall;
    }

    public void setClerkCall(String clerkCall) {
        this.clerkCall = clerkCall;
    }

    public String getClerkEmail() {
        return clerkEmail;
    }

    public void setClerkEmail(String clerkEmail) {
        this.clerkEmail = clerkEmail;
    }

    public String getClerkLink() {
        return clerkLink;
    }

    public void setClerkLink(String clerkLink) {
        this.clerkLink = clerkLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIncentive() {
        return incentive;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBtime() {
        return btime;
    }

    public void setBtime(String btime) {
        this.btime = btime;
    }
}
