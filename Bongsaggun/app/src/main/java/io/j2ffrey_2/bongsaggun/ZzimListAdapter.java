package io.j2ffrey_2.bongsaggun;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.homelist.HomeListItem;

/**
 * Created by andasom on 2015-10-15.
 */
public class ZzimListAdapter extends RecyclerView.Adapter<ZzimListAdapter.ZzimListViewHolder> {

    public static final String TAG = ZzimListAdapter.class.getSimpleName();

    public interface ListItemSelectedAllCallback {
        void onListItemSelectedAll(boolean selected);
    }

    public interface ListItemDeletedCallback {
        void onListItemDeleted();
    }

    private Context mContext;

    ZzimListViewHolder zzimListViewHolder;

    ArrayList<ZzimListItem> mZzimListItems;

    private ListItemSelectedAllCallback mListItemSelectedAllCallback;
    private ListItemDeletedCallback mListItemDeletedCallback;

    public ZzimListAdapter(Context context, Fragment fragment, ArrayList<ZzimListItem> data) {
        mContext = context;
        mZzimListItems = data;
        mListItemSelectedAllCallback = (ListItemSelectedAllCallback)fragment;
        mListItemDeletedCallback = (ListItemDeletedCallback)fragment;
    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return mZzimListItems.size();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ZzimListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_zzimlist, parent, false);

        zzimListViewHolder = new ZzimListViewHolder(view);

        return zzimListViewHolder;
    }

    public void onBindViewHolder(ZzimListViewHolder holder, final int position) {

        final ZzimListItem current = mZzimListItems.get(position);  //get current item

        holder.ivSumnail.setImageResource(current.getImgSumnail());
        holder.tvTitle.setText(current.getTitle());
        holder.tvVoluntaryPeriodStart.setText(current.getVoluntaryPeriodStart());
        holder.tvVoluntaryPeriodEnd.setText(current.getVoluntaryPeriodEnd());
        holder.tvVoluntaryWorkLocation.setText(current.getVoluntaryLocation());
        holder.tvVoluntaryWorkOrganization.setText(current.getVoluntaryOragination());
        holder.tvVoluntaryWorkTime.setText(current.getVoluntaryTime() + "시간");

        if (current.isSelected()) {
            holder.ivZzimSelected.setImageResource(R.drawable.ic_check_teal_24dp);
            holder.tvZzimSelected.setText(R.string.zzim_checkin);
        } else {
            holder.ivZzimSelected.setImageResource(R.drawable.ic_check_gray_24dp);
            holder.tvZzimSelected.setText(R.string.zzim_checkout);
        }
        holder.ivZzimCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: Zzim remove api 연결

                mZzimListItems.remove(position);
                mListItemDeletedCallback.onListItemDeleted();
                notifyDataSetChanged();
            }
        });

        holder.layoutZzimSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 하나라도 체크 해제되면 Fragment에 콜백으로 check box 해제시키기 -> 연쇄끊기

                current.setSelected(!current.isSelected());
                Log.d(TAG, " layoutZzimSelected" + isAllSelected());
                mListItemSelectedAllCallback.onListItemSelectedAll(isAllSelected());

                notifyDataSetChanged();
            }
        });
    }

    boolean isAllSelected() {
        for (int i = 0; i < mZzimListItems.size(); i++) {
            if (mZzimListItems.get(i).isSelected() == false)
                return false;
        }
        return true;
    }

    void allSelectedZzim(boolean selected) {
        for (int i = 0; i < mZzimListItems.size(); i++) {
            mZzimListItems.get(i).setSelected(selected);
        }
        notifyDataSetChanged();
    }

    public static class ZzimListViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imageView_sumnail)
        ImageView ivSumnail;
        @Bind(R.id.textVIew_title)
        TextView tvTitle;
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
        @Bind(R.id.container_check)
        RelativeLayout layoutZzimSelected;
        @Bind(R.id.textView_check)
        TextView tvZzimSelected;
        @Bind(R.id.imageView_check)
        ImageView ivZzimSelected;

        View mView;

        public ZzimListViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            ButterKnife.bind(this, mView);
        }
    }

    public void setData(ArrayList<ZzimListItem> list){
        mZzimListItems.clear();

        mZzimListItems = list;

        notifyDataSetChanged();
    }
}