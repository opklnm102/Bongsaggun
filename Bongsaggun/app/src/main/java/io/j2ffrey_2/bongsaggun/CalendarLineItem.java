package io.j2ffrey_2.bongsaggun;

/**
 * Created by dong on 2015-10-07.
 */
public class CalendarLineItem {

    public int sectionManager;

    public int sectionFirstPosition;

    public boolean isHeader;

    public VoluntaryWork voluntaryWork;  //data



    public CalendarLineItem(VoluntaryWork voluntaryWork, int sectionManager, int sectionFirstPosition, boolean isHeader) {
        this.sectionManager = sectionManager;
        this.sectionFirstPosition = sectionFirstPosition;
        this.isHeader = isHeader;
        this.voluntaryWork = voluntaryWork;
    }
}
