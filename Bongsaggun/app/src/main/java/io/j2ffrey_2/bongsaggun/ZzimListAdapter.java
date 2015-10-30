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

/**
 * Created by andasom on 2015-10-15.
 */
public class ZzimListAdapter extends RecyclerView.Adapter<ZzimListAdapter.MyViewHolder> {
private LayoutInflater inflater;
private List items;

        // 뿌려주는 값 받음
        List <Zzim_list_contents> mDataset = Collections.emptyList();

public ZzimListAdapter(Context context, List<Zzim_list_contents> data){

        inflater =LayoutInflater.from(context);
        mDataset = data;
        }
// Provide a suitable constructor (depends on the kind of dataset)



// Create new views (invoked by the layout manager)
@Override
public MyViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
        // create a new view
        View view = inflater.inflate(R.layout.zzim_custom_listview , parent, false);
        //parse
        MyViewHolder vh = new MyViewHolder(view);

        //view.setBackgroundResource();
        return vh;
        }

// Replace the contents of a view (invoked by the layout manager)
public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Zzim_list_contents current = mDataset.get(position);  //get current item
        holder.title.setText(current.title);
        holder.icon.setImageResource(current.IconId);

        }

// Return the size of your dataset (invoked by the layout manager)
public int getItemCount() {
        return mDataset.size();
        }

public static class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public final TextView title;
    public final ImageView icon;
    public final View mView;

    public MyViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        title = (TextView) itemView.findViewById(R.id.zzim_title);
        icon = (ImageView)itemView.findViewById(R.id.zzim_icon);
    }


}



}
