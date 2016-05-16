package io.j2ffrey_2.bongsaggun.models;

import io.j2ffrey_2.bongsaggun.models.CalendarItem;

/**
 * Created by dong on 2015-10-07.
 */
public class CalendarLineItem {

    public int sectionManager;

    public int sectionFirstPosition;

    public boolean isHeader;

    public CalendarItem mCalendarItem;  //data

    public CalendarLineItem(CalendarItem calendarItem, int sectionManager, int sectionFirstPosition, boolean isHeader) {
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
        this.isHeader = isHeader;
        this.mCalendarItem = calendarItem;
    }

    public int getSectionManager() {
        return sectionManager;
    }

    public void setSectionManager(int sectionManager) {
        this.sectionManager = sectionManager;
    }

    public int getSectionFirstPosition() {
        return sectionFirstPosition;
    }

    public void setSectionFirstPosition(int sectionFirstPosition) {
        this.sectionFirstPosition = sectionFirstPosition;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setIsHeader(boolean isHeader) {
        this.isHeader = isHeader;
    }

    public CalendarItem getCalendarItem() {
        return mCalendarItem;
    }

    public void setCalendarItem(CalendarItem calendarItem) {
        mCalendarItem = calendarItem;
    }
}
