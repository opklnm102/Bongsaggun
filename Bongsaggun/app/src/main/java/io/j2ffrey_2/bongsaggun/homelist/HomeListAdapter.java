package io.j2ffrey_2.bongsaggun.homelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.R;

/**
 * Created by vantovan on 2015. 10. 6..
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List items;

    // 뿌려주는 값 받음
    List<HomeListItem> mDataset = Collections.emptyList();

    public HomeListAdapter(Context context, List<HomeListItem> data) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mDataset = data;
    }
    // Provide a suitable constructor (depends on the kind of dataset)


    // Create new views (invoked by the layout manager)
    @Override
    public HomeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = inflater.inflate(R.layout.item_homelist, parent, false);

        return new HomeListViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(HomeListViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        HomeListItem current = mDataset.get(position);  //get current item

        holder.tvTitle.setText(current.getTitle());
        holder.ivSumnail.setImageResource(current.getImgSumnail());
        holder.tvDday.setText("D-" + current.getdDay());
        holder.tvVoluntaryPeriodStart.setText(current.getVoluntaryPeriodStart());
        holder.tvVoluntaryPeriodEnd.setText(current.getVoluntaryPeriodEnd());
        holder.tvVoluntaryWorkLocation.setText(current.getVoluntaryLocation());
        holder.tvVoluntaryWorkTime.setText(current.getVoluntaryTime() + "시간");

    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return mDataset.size();
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
