package io.j2ffrey_2.bongsaggun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tonicartos.superslim.LayoutManager;
import com.tonicartos.superslim.LinearSLM;

import java.util.ArrayList;

/**
 * Created by dong on 2015-10-06.
 */
public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder> {

    private static final int VIEW_TYPE_HEADER = 0x01;

    private static final int VIEW_TYPE_CONTENT = 0x00;

    private static final int LINEAR = 0;

    private ArrayList<CalendarLineItem> mCalendarLineItemArrayList;
    private ArrayList<VoluntaryWork> mVoluntaryWorkArrayList;

    private Context context;

    private int mHeaderDisplay;

    private boolean mMarginsFixed;

    private int sectionManager;

    public CalendarAdapter(Context context) {
        this.context = context;
        this.mCalendarLineItemArrayList = new ArrayList<>();

        mHeaderDisplay = LayoutManager.LayoutParams.HEADER_ALIGN_START;
        mMarginsFixed = true;
        sectionManager = LINEAR;

        //dummyData
        for(int i=1; i<10; i++){
            mVoluntaryWorkArrayList.add(new VoluntaryWork("2015","10",Integer.toString(i),"월",false,"D-4","봉사닷","서울","24시간"));
            mVoluntaryWorkArrayList.add(new VoluntaryWork("2015","9",Integer.toString(i),"월",false,"D-2","봉봉","문산","24시간"));
            mVoluntaryWorkArrayList.add(new VoluntaryWork("2015","10",Integer.toString(i),"월",false,"D-2","봉봉","문산","24시간"));
            mVoluntaryWorkArrayList.add(new VoluntaryWork("2015","10",Integer.toString(i),"월",false,"D-2","봉봉","문산","24시간"));
            mVoluntaryWorkArrayList.add(new VoluntaryWork("2015","10",Integer.toString(i),"월",false,"D-2","봉봉","문산","24시간"));
        }



        //insert headers into list of items
        String lastHeader = "";
        int sectionManager = -1;
        int headerCount = 0;
        int sectionFirstPosition = 0;
        for(int i=0; i<mCalendarLineItemArrayList.size(); i++){
            String header = mVoluntaryWorkArrayList.get(i).getMonth();
            if(!TextUtils.equals(lastHeader, header)){
                //insert new header view and update section data.
                sectionManager = (sectionManager + 1) % 2;
                sectionFirstPosition = i + headerCount;
                lastHeader = header;
                headerCount += 1;
                mCalendarLineItemArrayList.add(new CalendarLineItem(sectionManager,sectionFirstPosition,true,header));
            }
            mCalendarLineItemArrayList.add(new CalendarLineItem())
        }


    }

    public void setCalendarData(ArrayList<CalendarLineItem> list) {
        mCalendarLineItemArrayList = list;
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
        CalendarLineItem item = mCalendarLineItemArrayList.get(position);

        final View itemView = holder.itemView;

        LayoutManager.LayoutParams lp = (LayoutManager.LayoutParams) itemView.getLayoutParams();

        if (item.isHeader) {
            lp.headerDisplay = mHeaderDisplay;
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            lp.headerEndMarginIsAuto = !mMarginsFixed;
            lp.headerStartMarginIsAuto = !mMarginsFixed;
        }

        lp.setSlm(LinearSLM.ID);
        itemView.setLayoutParams(lp);
    }

    @Override
    public int getItemCount() {
        return mCalendarLineItemArrayList.size();
    }


}
