package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tonicartos.superslim.LayoutManager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CalendarFragment extends Fragment {

    public static final String TAG = "CalendarFragment";

    private ViewHolder mViews;

    private CalendarAdapter mCalendarAdapter;

    private int mHeaderDisplay;

    private boolean mAreMarginsFixed;  //필요

    @Bind(R.id.textView_calendar_title) TextView tvCalendarTitle;
    @Bind(R.id.imageView_calendar_before) ImageView tvCalendarBefore;
    @Bind(R.id.imageView_calendar_after) ImageView tvCalendarAfter;

    public static CalendarFragment newInstance() {
        CalendarFragment fragment = new CalendarFragment();

        return fragment;
    }

    public CalendarFragment() {
        // Required empty public constructor
    }

    public void setHeaderSticky(boolean areHeadersSticky){
        mHeaderDisplay = areHeadersSticky ? mHeaderDisplay
                | LayoutManager.LayoutParams.HEADER_STICKY
                : mHeaderDisplay & ~LayoutManager.LayoutParams.HEADER_STICKY;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHeaderDisplay = 18;
        mAreMarginsFixed = true;

        mViews = new ViewHolder(view);
        mViews.initViews(new LayoutManager(getActivity()));
        setHeaderSticky(true);
        mCalendarAdapter = new CalendarAdapter(getActivity(), mHeaderDisplay);
        mViews.setAdapter(mCalendarAdapter);
    }

    private static class ViewHolder {

        private final RecyclerView rvCalendar;

        public ViewHolder(View view){
            rvCalendar = (RecyclerView)view.findViewById(R.id.recyclerView_calendar);
        }

        public void initViews(LayoutManager lm){
            rvCalendar.setLayoutManager(lm);
        }

        public void scrollToPosition(int position){
            rvCalendar.scrollToPosition(position);
        }

        public void setAdapter(RecyclerView.Adapter<?> adapter){
            rvCalendar.setAdapter(adapter);
        }

        public void smoothScrollToPosition(int position){
            rvCalendar.smoothScrollToPosition(position);
        }
    }
}
