package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.content.Context;

import android.content.Intent;
import android.net.Uri;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tonicartos.superslim.LayoutManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;


public class CalendarFragment extends Fragment {

    public static final String TAG = "CalendarFragment";

    private ViewHolder mViews;

    private CalendarAdapter mCalendarAdapter;

    private int mHeaderDisplay;

    private boolean mAreMarginsFixed;  //필요

    private HashMap<String, VoluntaryWork> voluntaryWorkHashMap;
    private ArrayList<VoluntaryWork> mVoluntaryWorkArrayList;
    private Integer currYear;  //현재 년도
    private Integer currMonth;  //현재 월

    @Bind(R.id.textView_calendar_title)
    TextView tvCalendarTitle;
    @Bind(R.id.imageView_calendar_before)
    ImageView tvCalendarBefore;
    @Bind(R.id.imageView_calendar_after)
    ImageView tvCalendarAfter;

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();

        return fragment;
    }

    public CalendarFragment() {
        // Required empty public constructor
    }

    public void setHeaderSticky(boolean areHeadersSticky) {
        mHeaderDisplay = areHeadersSticky ? mHeaderDisplay
                | LayoutManager.LayoutParams.HEADER_STICKY
                : mHeaderDisplay & ~LayoutManager.LayoutParams.HEADER_STICKY;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        voluntaryWorkHashMap = new HashMap<>();
        mVoluntaryWorkArrayList = new ArrayList<>();
        currYear = getCurrentYear();
        currMonth = getCurrentMonth();

        Log.d(TAG, " currYear " + currYear);
        Log.d(TAG, " currMonth " + currMonth);

        mHeaderDisplay = 18;
        mAreMarginsFixed = true;

        mViews = new ViewHolder(view);
        mViews.initViews(new LayoutManager(getActivity()));
        setHeaderSticky(true);
        mCalendarAdapter = new CalendarAdapter(getActivity(), mHeaderDisplay);
        mViews.setAdapter(mCalendarAdapter);

        tvCalendarBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: hash map에서 이전 월에 대한 ArrayList를 꺼낸다.
                if(currMonth == 1){
                    currYear -= 1;
                    currMonth = 12;
                }else{
                    currMonth -= 1;
                }
                voluntaryWorkHashMap.get(currMonth);  //list에 담는다. 년도는 어떻게 처리..?
                tvCalendarTitle.setText(currYear.toString() + "년 " + currMonth.toString() + "월");
                Log.d(TAG, "before currMonth " + currMonth);
            }
        });

        tvCalendarAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: hash map에서 다음 월에 대한 ArrayList를 꺼낸다.
                if(currMonth == 12){
                    currYear += 1;
                    currMonth = 1;
                }else{
                    currMonth += 1;
                }
                voluntaryWorkHashMap.get(currMonth);   //list에 담는다. 년도는 어떻게 처리..?
                tvCalendarTitle.setText(currYear.toString() + "년 " + currMonth.toString() + "월");
                Log.d(TAG, "after currMonth " + currMonth);
            }
        });
    }

    public int getCurrentYear() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    public int getCurrentMonth() {
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH) + 1;
    }

    private static class ViewHolder {

        private final RecyclerView rvCalendar;

        public ViewHolder(View view) {
            rvCalendar = (RecyclerView) view.findViewById(R.id.recyclerView_calendar);
        }

        public void initViews(LayoutManager lm) {
            rvCalendar.setLayoutManager(lm);
        }

        public void scrollToPosition(int position) {
            rvCalendar.scrollToPosition(position);
        }

        public void setAdapter(RecyclerView.Adapter<?> adapter) {
            rvCalendar.setAdapter(adapter);
        }

        public void smoothScrollToPosition(int position) {
            rvCalendar.smoothScrollToPosition(position);
        }
    }
}
