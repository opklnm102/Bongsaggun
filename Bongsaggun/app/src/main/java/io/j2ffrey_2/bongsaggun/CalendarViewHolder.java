package io.j2ffrey_2.bongsaggun;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by dong on 2015-10-06.
 */
public class CalendarViewHolder extends RecyclerView.ViewHolder {

    /**
     * header
     **/
    @Bind(R.id.textView_calendar_day)
    TextView tvCalendarDay;
    @Bind(R.id.text_calendar_dayOfWeek)
    TextView tvCalendarDayOfWeek;

    /**
     * line
     **/
    @Bind(R.id.imageView_voluntaryWork_state)
    ImageView ivVoluntaryWorkState;
    @Bind(R.id.textView_voluntaryWork_dDay)
    TextView tvVoluntaryWorkDday;
    @Bind(R.id.textView_voluntaryWork_title)
    TextView tvVoluntaryWorkTitle;
    @Bind(R.id.textView_voluntaryWork_location)
    TextView tvVoluntaryWorkLocation;
    @Bind(R.id.textView_voluntaryWork_time)
    TextView tvVoluntaryWorkTime;

    public CalendarViewHolder(View view) {
        super(view);

        ButterKnife.bind(this, view);
    }

    public void bindItem(VoluntaryWork voluntaryWork) {

        //header
        tvCalendarDay.setText(voluntaryWork.getDay());
        tvCalendarDayOfWeek.setText(voluntaryWork.getDayOfWeek());

        //line
        if(voluntaryWork.isState()){
            ivVoluntaryWorkState.setImageResource(R.mipmap.ic_logo);
        }else{
            ivVoluntaryWorkState.setImageResource(R.mipmap.ic_launcher);
        }
        tvVoluntaryWorkDday.setText(voluntaryWork.getdDay());
        tvVoluntaryWorkTitle.setText(voluntaryWork.getTitle());
        tvVoluntaryWorkLocation.setText(voluntaryWork.getLocation());
        tvVoluntaryWorkTime.setText(voluntaryWork.getTime());
    }
}
