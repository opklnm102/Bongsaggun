package io.j2ffrey_2.bongsaggun;

/**
 * Created by Dong on 2015-11-12.
 */
public class ZzimListItem {

    int imgSumnail;
    String title;
    String voluntaryPeriodStart;
    String voluntaryPeriodEnd;
    String voluntaryLocation;
    String voluntaryOragination;
    int voluntaryTime;
    boolean selected;

    public ZzimListItem() {
        this.imgSumnail = 0;
        this.title = "";
        this.voluntaryPeriodStart = "";
        this.voluntaryPeriodEnd = "";
        this.voluntaryLocation = "";
        this.voluntaryOragination = "";
        this.voluntaryTime = 0;
        this.selected = false;
    }

    public ZzimListItem(int imgSumnail, String title, String voluntaryPeriodStart, String voluntaryPeriodEnd, String voluntaryLocation, String voluntaryOragination, int voluntaryTime, boolean selected) {
        this.imgSumnail = imgSumnail;
        this.title = title;
        this.voluntaryPeriodStart = voluntaryPeriodStart;
        this.voluntaryPeriodEnd = voluntaryPeriodEnd;
        this.voluntaryLocation = voluntaryLocation;
        this.voluntaryOragination = voluntaryOragination;
        this.voluntaryTime = voluntaryTime;
        this.selected = selected;
    }

    public int getImgSumnail() {
        return imgSumnail;
    }

    public void setImgSumnail(int imgSumnail) {
        this.imgSumnail = imgSumnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getVoluntaryOragination() {
        return voluntaryOragination;
    }

    public void setVoluntaryOragination(String voluntaryOragination) {
        this.voluntaryOragination = voluntaryOragination;
    }

    public int getVoluntaryTime() {
        return voluntaryTime;
    }

    public void setVoluntaryTime(int voluntaryTime) {
        this.voluntaryTime = voluntaryTime;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
