package io.j2ffrey_2.bongsaggun;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tonicartos.superslim.LayoutManager;
import com.tonicartos.superslim.LinearSLM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by dong on 2015-10-06.
 */

//Todo: 월 필터링 추가
//Todo: api 연결하기
public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    public static final String TAG = "CalendarAdapter";

    private static final int VIEW_TYPE_HEADER = 0x01;

    private static final int VIEW_TYPE_CONTENT = 0x00;

    private static final int LINEAR = 0;

    private ArrayList<CalendarLineItem> mCalendarLineItemArrayList;
    private ArrayList<CalendarItem> mCalendarItemArrayList;

    private Context mContext;

    private int mHeaderDisplay;

    private boolean mMarginsFixed;

    private int sectionManager;

    public CalendarAdapter(Context context, int headerMode) {
        this.mContext = context;
        this.mCalendarLineItemArrayList = new ArrayList<>();
        this.mCalendarItemArrayList = new ArrayList<>();

        mHeaderDisplay = headerMode;
        mMarginsFixed = true;
        sectionManager = LINEAR;

        //dummyData
//        for (int i = 1; i < 10; i++) {
//            mCalendarItemArrayList.add(new CalendarItem("2015", "10", Integer.toString(i), "월", false, "D-4", "봉사닷", "서울", "4시간"));
//            mCalendarItemArrayList.add(new CalendarItem("2015", "9", Integer.toString(i), "월", false, "D-2", "봉봉", "문산", "5시간"));
//            mCalendarItemArrayList.add(new CalendarItem("2015", "10", Integer.toString(i), "월", true, "D-2", "봉황", "진산", "6시간"));
//            mCalendarItemArrayList.add(new CalendarItem("2015", "10", Integer.toString(i), "월", false, "D-2", "황황", "가산", "7시간"));
//            mCalendarItemArrayList.add(new CalendarItem("2015", "10", Integer.toString(i), "월", true, "D-2", "봉황만세세ㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔㅔ", "오산", "8시간"));
//        }

//        insertHeaderView();
    }

    private void insertHeaderView() {
        mCalendarLineItemArrayList.clear();

        //insert headers into list of items
        String lastHeader = "";
        int sectionManager = -1;
        int headerCount = 0;
        int sectionFirstPosition = 0;
        for (int i = 0; i < mCalendarItemArrayList.size(); i++) {
            String header = String.valueOf(mCalendarItemArrayList.get(i).getDay());
            if (!TextUtils.equals(lastHeader, header)) {
                //insert new header view and update section data.
                sectionManager = (sectionManager + 1) % 2;
                sectionFirstPosition = i + headerCount;
                lastHeader = header;
                headerCount += 1;

                mCalendarLineItemArrayList.add(new CalendarLineItem(mCalendarItemArrayList.get(i), sectionManager, sectionFirstPosition, true));
            }
            mCalendarLineItemArrayList.add(new CalendarLineItem(mCalendarItemArrayList.get(i), sectionManager, sectionFirstPosition, false));
        }
    }

    public void setData(ArrayList<CalendarItem> list) {
        mCalendarItemArrayList.clear();

        mCalendarItemArrayList = list;

        //오름차순 정렬
        Collections.sort(mCalendarItemArrayList, new Comparator<CalendarItem>() {
            @Override
            public int compare(CalendarItem obj1, CalendarItem obj2) {
                return (obj1.getDay() < obj2.getDay()) ? -1 : (obj1.getDay() > obj2.getDay()) ? 1 : 0;
            }
        });

        //헤더처리
        insertHeaderView();

        notifyDataSetChanged();
    }

    public boolean isItemHeader(int position) {
        return mCalendarLineItemArrayList.get(position).isHeader;
    }

    @Override
    public CalendarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_HEADER) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_calendar, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_line_calendar, parent, false);
        }
        return new CalendarViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return mCalendarLineItemArrayList.get(position).isHeader ? VIEW_TYPE_HEADER : VIEW_TYPE_CONTENT;
    }

    @Override
    public void onBindViewHolder(CalendarViewHolder holder, int position) {

        if (mCalendarLineItemArrayList.size() == 0) {
            return;
        }

        final CalendarLineItem item = mCalendarLineItemArrayList.get(position);
        final View itemView = holder.mView;

        Log.e(TAG, item.mCalendarItem.getTitle());
        holder.bindItem(item.mCalendarItem, item.isHeader);

        LayoutManager.LayoutParams lp = (LayoutManager.LayoutParams) itemView.getLayoutParams();

        if (item.isHeader) {
            lp.headerDisplay = mHeaderDisplay;
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            lp.headerEndMarginIsAuto = !mMarginsFixed;
            lp.headerStartMarginIsAuto = !mMarginsFixed;
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InfoPageActivity.class);
                intent.putExtra("voluntaryId", item.getCalendarItem().getVoluntaryId());
                mContext.startActivity(intent);
            }
        });

        lp.setSlm(LinearSLM.ID);
        lp.setFirstPosition(item.sectionFirstPosition);
        itemView.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return mCalendarLineItemArrayList.size();
    }
}
