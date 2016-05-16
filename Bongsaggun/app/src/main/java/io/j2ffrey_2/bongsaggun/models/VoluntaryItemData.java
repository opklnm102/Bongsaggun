package io.j2ffrey_2.bongsaggun.models;

/**
 * Created by Dong on 2015-11-16.
 */
public class VoluntaryItemData {

    int id;
    String title;  //봉사제목
    int dDay;  //모집까지 디데이 -> 계산해야함
    String dateRealStart;  //봉사기간 시작
    String dateRealEnd;  //봉사기간 끝
    String dateRecruitStart;  //모집기간 시작
    String dateRecruitEnd;  //모집기간 끝
    int totalTime;  //봉사시간
    String address;  //봉사할 장소
    boolean approval;  //인증서 발급여부

    int imgMain;  //메인이미지 blob
    String imgMainUrl;  //메인이미지 url
    int imgPoster;  //포스터이미지 blob
    String imgPosterUrl;  //포스터이미지 url

    String require;  //지원가능 조건
    int recruitTotalCount;  //모집인원
    int recruitCurrentCount;  //현재 신청인원
    String clerkName;  //담당자 이름
    String clerkCall;  //담당자 전화
    String clerkEmail;  //담장자 이메일
    String clerkLink;  //담당자 링크

    String incentive;  //활동혜택
    String contentEtc;  //기타사항
    String organization;  //봉사기관


    String bTime;    //봉사시간 분류(검색용)
    String category;  //봉사종류 분류(검색용)
    String region;  //봉사지역 분류(검색용)
    String schoo;  //학교 분류(검색용)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDateRealStart() {
        return dateRealStart;
    }

    public void setDateRealStart(String dateRealStart) {
        this.dateRealStart = dateRealStart;
    }

    public String getDateRealEnd() {
        return dateRealEnd;
    }

    public void setDateRealEnd(String dateRealEnd) {
        this.dateRealEnd = dateRealEnd;
    }

    public String getDateRecruitStart() {
        return dateRecruitStart;
    }

    public void setDateRecruitStart(String dateRecruitStart) {
        this.dateRecruitStart = dateRecruitStart;
    }

    public String getDateRecruitEnd() {
        return dateRecruitEnd;
    }

    public void setDateRecruitEnd(String dateRecruitEnd) {
        this.dateRecruitEnd = dateRecruitEnd;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
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

    public int getImgMain() {
        return imgMain;
    }

    public void setImgMain(int imgMain) {
        this.imgMain = imgMain;
    }

    public String getImgMainUrl() {
        return imgMainUrl;
    }

    public void setImgMainUrl(String imgMainUrl) {
        this.imgMainUrl = imgMainUrl;
    }

    public int getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(int imgPoster) {
        this.imgPoster = imgPoster;
    }

    public String getImgPosterUrl() {
        return imgPosterUrl;
    }

    public void setImgPosterUrl(String imgPosterUrl) {
        this.imgPosterUrl = imgPosterUrl;
    }

    public String getRequire() {
        return require;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public int getRecruitTotalCount() {
        return recruitTotalCount;
    }

    public void setRecruitTotalCount(int recruitTotalCount) {
        this.recruitTotalCount = recruitTotalCount;
    }

    public int getRecruitCurrentCount() {
        return recruitCurrentCount;
    }

    public void setRecruitCurrentCount(int recruitCurrentCount) {
        this.recruitCurrentCount = recruitCurrentCount;
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

    public String getIncentive() {
        return incentive;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }

    public String getContentEtc() {
        return contentEtc;
    }

    public void setContentEtc(String contentEtc) {
        this.contentEtc = contentEtc;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSchoo() {
        return schoo;
    }

    public void setSchoo(String schoo) {
        this.schoo = schoo;
    }
}
