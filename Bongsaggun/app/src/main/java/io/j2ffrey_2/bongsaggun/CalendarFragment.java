package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tonicartos.superslim.LayoutManager;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.model.Token;
import io.j2ffrey_2.bongsaggun.view.RecyclerViewEmptySupport;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class CalendarFragment extends BaseFragment {

    public static final String TAG = CalendarFragment.class.getSimpleName();

    private ViewHolder mViews;

    private CalendarAdapter mCalendarAdapter;

    private int mHeaderDisplay;

    private boolean mAreMarginsFixed;  //필요

    private ArrayList<CalendarItem> mCalendarItemArrayList;
    private Integer currYear;  //현재 년도
    private Integer currMonth;  //현재 월

    @Bind(R.id.textView_calendar_title)
    TextView tvCalendarTitle;
    @Bind(R.id.imageView_calendar_before)
    ImageView tvCalendarBefore;
    @Bind(R.id.imageView_calendar_after)
    ImageView tvCalendarAfter;

    @Bind(R.id.viewSwitcher_calendar)
    ViewSwitcher vsCalendar;

    Animation slide_in_left, slide_out_right;

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

        mCalendarItemArrayList = new ArrayList<>();
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

        //animation
        slide_in_left = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_out_right);
        vsCalendar.setInAnimation(slide_in_left);
        vsCalendar.setOutAnimation(slide_out_right);

        tvCalendarTitle.setText(currYear.toString() + "년 " + currMonth.toString() + "월");

        tvCalendarBefore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: hash map에서 이전 월에 대한 ArrayList를 꺼낸다.
                if (currMonth == 1) {
                    currYear -= 1;
                    currMonth = 12;
                } else {
                    currMonth -= 1;
                }
                getCalendarList(currYear, currMonth);
                tvCalendarTitle.setText(currYear.toString() + "년 " + currMonth.toString() + "월");
                Log.d(TAG, "before currMonth " + currMonth);
                vsCalendar.showPrevious();
            }
        });

        tvCalendarAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Todo: hash map에서 다음 월에 대한 ArrayList를 꺼낸다.
                if (currMonth == 12) {
                    currYear += 1;
                    currMonth = 1;
                } else {
                    currMonth += 1;
                }
                getCalendarList(currYear, currMonth);
                tvCalendarTitle.setText(currYear.toString() + "년 " + currMonth.toString() + "월");
                Log.d(TAG, "after currMonth " + currMonth);
                vsCalendar.showNext();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getCalendarList(currYear, currMonth);
    }

    public void getCalendarList(int year, int month) {

        mCalendarItemArrayList = new ArrayList<>();

        Call<JsonObject> call = requestHelper.getCalendarList(year, month);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Response<JsonObject> response, Retrofit retrofit) {

                JsonObject jsonObject = response.body();

                if (jsonObject != null) {

                    Log.d(TAG, " jsonObject is " + jsonObject);

                    Token token = new Gson().fromJson(jsonObject.getAsJsonObject("Token"), Token.class);

                    if (token.getStatus() == 200) {  //데이터 얻기 성공
                        JsonArray jsonArray = jsonObject.getAsJsonArray("Bongsa");

                        for (int i = 0; i < jsonArray.size(); i++) {
                            CalendarItem item = new Gson().fromJson(jsonArray.get(i), CalendarItem.class);
                            mCalendarItemArrayList.add(item);
                            Log.e(TAG, " " + item.getId() + item.getdDay() + item.getRegion() + item.getTitle() + item.getType() + item.getDayOfWeek() + item.getDay());
                        }
                    } else {
                        //데이터 얻기 실패
                    }
                    mCalendarAdapter.setCalendarData(mCalendarItemArrayList);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, " Throwable is " + t);
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

        private final RecyclerViewEmptySupport rvCalendar;
        private final TextView tvEmpty;

        public ViewHolder(View view) {
            rvCalendar = (RecyclerViewEmptySupport) view.findViewById(R.id.recyclerView_calendar);
            tvEmpty = (TextView) view.findViewById(R.id.textView_empty_calendar);
            rvCalendar.setEmptyView(tvEmpty);
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
