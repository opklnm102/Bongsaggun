package io.j2ffrey_2.bongsaggun;

/**
 * Created by User on 2015-10-07.
 */
public class CalendarLineItem {

    public int sectionManager;

    public int sectionFirstPosition;

    public boolean isHeader;

    public String text;

    public CalendarLineItem(int sectionManager, int sectionFirstPosition, boolean isHeader, String text) {
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
        this.isHeader = isHeader;
        this.text = text;
    }
}
