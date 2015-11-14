package io.j2ffrey_2.bongsaggun;


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

/**
 * Created by andasom on 2015-10-15.
 */
public class ZzimListAdapter extends RecyclerView.Adapter<ZzimListAdapter.MyViewHolder> {

    public static final String TAG = ZzimListAdapter.class.getSimpleName();

    private Context mContext;
    private LayoutInflater inflater;

    List<ZzimListItem> mDataset = Collections.emptyList();

    public ZzimListAdapter(Context context, List<ZzimListItem> data) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mDataset = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_zzimlist, parent, false);

        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {

       ZzimListItem current = mDataset.get(position);  //get current item

        holder.tvTitle.setText(current.getTitle());
        holder.ivSumnail.setImageResource(current.getImgSumnail());
        holder.tvDday.setText("D-" + current.getdDay());
        holder.tvVoluntaryPeriodStart.setText(current.getVoluntaryPeriodStart());
        holder.tvVoluntaryPeriodEnd.setText(current.getVoluntaryPeriodEnd());
        holder.tvVoluntaryWorkLocation.setText(current.getVoluntaryLocation());
        holder.tvVoluntaryWorkLocation.setText(current.getVoluntaryOragination());
        holder.tvVoluntaryWorkTime.setText(current.getVoluntaryTime() + "시간");




    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

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
        @Bind(R.id.textView_organization)
        TextView tvVoluntaryWorkOrganization;
        @Bind(R.id.textView_time)
        TextView tvVoluntaryWorkTime;
        @Bind(R.id.imageView_cancel_zzim)
        ImageView ivZzimCancel;

        View mView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            ButterKnife.bind(this, mView);
        }
    }
}
