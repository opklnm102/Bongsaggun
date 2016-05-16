package io.j2ffrey_2.bongsaggun.views.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.activities.InfoPageActivity;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.models.SearchListItem;

/**
 * Created by Dong on 2015-11-15.
 */
public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchListViewHolder> {

    public static final String TAG = SearchListAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<SearchListItem> items;
    private LayoutInflater mLayoutInflater;

    public SearchListAdapter(Context context, ArrayList<SearchListItem> data){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
        items = data;
    }

    @Override
    public SearchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_searchlist, parent, false);

        return new SearchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchListViewHolder holder, int position) {

        final SearchListItem item = items.get(position);

        holder.tvTitle.setText(item.getTitle());

        String imgMainUrl = item.getImgMainUrl();

        Log.d(TAG, " imgMainUrl " + imgMainUrl);

        if(!"null".equals(imgMainUrl)){
            Glide.with(mContext).
                    load(imgMainUrl)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_logo)
                    .crossFade()
                    .into(holder.ivSumnail);
        }else{
            Glide.with(mContext).
                    load(R.mipmap.ic_logo)
                    .centerCrop()
                    .crossFade()
                    .into(holder.ivSumnail);
        }

        holder.tvDday.setText("D-" + item.getdDay());
        holder.tvVoluntaryPeriodStart.setText(item.getVoluntaryDateRecruitStart());
        holder.tvVoluntaryPeriodEnd.setText(item.getVoluntaryDateRecruitEnd());
        holder.tvVoluntaryRegion.setText(item.getRegion());
        holder.tvVoluntaryTime.setText(item.getVoluntaryTime() + "시간");

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InfoPageActivity.class);
                intent.putExtra("voluntaryId", item.getVoluntaryId());
                Log.e(TAG, " voluntaryId " + item.getVoluntaryId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class SearchListViewHolder extends RecyclerView.ViewHolder{

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
        TextView tvVoluntaryRegion;
        @Bind(R.id.textView_time)
        TextView tvVoluntaryTime;

        View mView;

        public SearchListViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }

    public void setData(ArrayList<SearchListItem> list){
        items.clear();

        items = list;

        notifyDataSetChanged();
    }
}
