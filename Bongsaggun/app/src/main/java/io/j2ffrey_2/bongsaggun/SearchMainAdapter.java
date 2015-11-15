package io.j2ffrey_2.bongsaggun;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Dong on 2015-11-15.
 */
public class SearchMainAdapter extends RecyclerView.Adapter<SearchMainAdapter.SearchListViewHolder> {

    private Context mContext;
    private List<SearchListItem> items;

    public SearchMainAdapter(Context context, List<SearchListItem> data){
        mContext = context;
        items = data;
    }

    @Override
    public SearchListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_searchlist, parent, false);

        return new SearchListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchListViewHolder holder, int position) {

        SearchListItem item = items.get(position);

        holder.tvTitle.setText(item.getTitle());
        holder.ivSumnail.setImageResource(item.getImgSumnail());
        holder.tvDday.setText("D-" + item.getdDay());
        holder.tvVoluntaryPeriodStart.setText(item.getVoluntaryPeriodStart());
        holder.tvVoluntaryPeriodEnd.setText(item.getVoluntaryPeriodEnd());
        holder.tvVoluntaryWorkLocation.setText(item.getVoluntaryLocation());
        holder.tvVoluntaryWorkTime.setText(item.getVoluntaryTime() + "시간");
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
        TextView tvVoluntaryWorkLocation;
        @Bind(R.id.textView_time)
        TextView tvVoluntaryWorkTime;

        View mView;

        public SearchListViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }
}
