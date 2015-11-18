package io.j2ffrey_2.bongsaggun.homelist;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.CursorRecyclerViewAdapter;
import io.j2ffrey_2.bongsaggun.R;

/**
 * Created by vantovan on 2015. 10. 6..
 */

public class HomeListAdapter extends CursorRecyclerViewAdapter<HomeListAdapter.HomeListViewHolder> {

    public static final String TAG = HomeListAdapter.class.getSimpleName();

    private Context mContext;
    private final LayoutInflater mInflater;

    public HomeListAdapter(Context context, Cursor cursor) {
        super(context, cursor);
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public HomeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemView = mInflater.inflate(R.layout.item_homelist, parent, false);

        return new HomeListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeListViewHolder viewHolder, Cursor cursor) {
        HomeListItem homeListItem = HomeListItem.fromCursor(cursor);



        viewHolder.tvTitle.setText(homeListItem.getTitle());

        String imgSumailUrl = homeListItem.getImgSumnailUrl();

        Log.e(TAG,imgSumailUrl);

        if(!"null".equals(imgSumailUrl)){
            Glide.with(mContext).
                    load(imgSumailUrl)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_logo)
                    .crossFade()
                    .into(viewHolder.ivSumnail);
        }else{
            Glide.with(mContext).
                    load(R.mipmap.ic_logo)
                    .centerCrop()
                    .crossFade()
                    .into(viewHolder.ivSumnail);
        }
//        viewHolder.ivSumnail.setImageResource(homeListItem.getImgSumnail());

        viewHolder.tvDday.setText("D-" + homeListItem.getdDay());
        viewHolder.tvVoluntaryPeriodStart.setText(homeListItem.getVoluntaryDateRecruitStart());
        viewHolder.tvVoluntaryPeriodEnd.setText(homeListItem.getVoluntaryDateRecruitEnd());
        viewHolder.tvVoluntaryWorkLocation.setText(homeListItem.getVoluntaryRegion());
        viewHolder.tvVoluntaryWorkTime.setText(homeListItem.getVoluntaryTime() + "시간");
    }

    public static class HomeListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.textVIew_title)
        TextView tvTitle;
        @Bind(R.id.imageView_sumnail)
        ImageView ivSumnail;
        @Bind(R.id.textView_Dday)
        TextView tvDday;
        @Bind(R.id.textView_voluntaryPeriod_start)
        TextView tvVoluntaryPeriodStart;
        @Bind(R.id.textView_voluntaryPeriod_end)
        TextView tvVoluntaryPeriodEnd;
        @Bind(R.id.textView_location)
        TextView tvVoluntaryWorkLocation;
        @Bind(R.id.textView_time)
        TextView tvVoluntaryWorkTime;

        View mView;

        public HomeListViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }
}
