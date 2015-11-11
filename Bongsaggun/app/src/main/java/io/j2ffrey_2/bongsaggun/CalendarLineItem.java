package io.j2ffrey_2.bongsaggun;

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
}
