package io.j2ffrey_2.bongsaggun;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by dong on 2015-10-06.
 */
public class CalendarViewHolder extends RecyclerView.ViewHolder {

    public View mView;
    /**
     * header
     **/
    @Bind(R.id.textView_calendar_day)
    @Nullable
    TextView tvCalendarDay;
    @Bind(R.id.text_calendar_dayOfWeek)
    @Nullable
    TextView tvCalendarDayOfWeek;

    /**
     * line
     **/
    @Bind(R.id.imageView_voluntaryWork_state)
    @Nullable
    ImageView ivVoluntaryWorkState;
    @Bind(R.id.textView_voluntaryWork_dDay)
    @Nullable
    TextView tvVoluntaryWorkDday;
    @Bind(R.id.textView_voluntaryWork_title)
    @Nullable
    TextView tvVoluntaryWorkTitle;
    @Bind(R.id.textView_voluntaryWork_location)
    @Nullable
    TextView tvVoluntaryWorkLocation;
    @Bind(R.id.textView_voluntaryWork_time)
    @Nullable
    TextView tvVoluntaryWorkTime;

    public CalendarViewHolder(View view) {
        super(view);

        mView = view;
        ButterKnife.bind(this, view);
    }

    public void bindItem(CalendarItem calendarItem, boolean isHeader) {

        if (isHeader) {
            //header
            tvCalendarDay.setText(String.valueOf(calendarItem.getDay()));
            tvCalendarDayOfWeek.setText(calendarItem.getDayOfWeek());
        } else {
            //line
            if (calendarItem.getType() == 1) {
                ivVoluntaryWorkState.setImageResource(R.drawable.img_recruit_start);
            } else if(calendarItem.getType() == 2) {
                ivVoluntaryWorkState.setImageResource(R.drawable.img_recruit_finish);
            }
            if(calendarItem.getdDay() > 0){
                tvVoluntaryWorkDday.setText("D-" + calendarItem.getdDay());
            }else{
                tvVoluntaryWorkDday.setText("D-0");
            }

            tvVoluntaryWorkTitle.setText(calendarItem.getTitle());
            tvVoluntaryWorkLocation.setText(calendarItem.getRegion());
//            tvVoluntaryWorkTime.setText(calendarItem.getTime());
        }
    }
}
