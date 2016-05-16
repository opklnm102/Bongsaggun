package io.j2ffrey_2.bongsaggun.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.models.ZzimListItem;
import io.j2ffrey_2.bongsaggun.views.RecyclerViewEmptySupport;
import io.j2ffrey_2.bongsaggun.views.adapters.ZzimListAdapter;

public class ZzimFragment extends android.support.v4.app.Fragment implements ZzimListAdapter.ListItemSelectedAllCallback, ZzimListAdapter.ListItemDeletedCallback {

    public static final String TAG = "ZzimFragment";

    @Bind(R.id.textView_zzim_total_num)
    TextView tvZzimTotalNum;
//    @Bind(R.id.button_zzim_application)
//    Button btnZZimApplication;
    @Bind(R.id.checkbox_zzim_all)
    CheckBox cbZzimAll;
    @Bind(R.id.recyclerView_zzim)
    RecyclerViewEmptySupport rvZzim;
    @Bind(R.id.textView_empty_zzim)
    TextView tvEmpty;

    ZzimListAdapter mZzimListAdapter;
    ArrayList<ZzimListItem> mZzimListItems;

    public static ZzimFragment newInstance() {
        ZzimFragment newFragment = new ZzimFragment();
        return newFragment;
    }

    public ZzimFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zzim, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mZzimListItems = new ArrayList<>();

        mZzimListAdapter = new ZzimListAdapter(getActivity(), this, mZzimListItems);
        rvZzim.setAdapter(mZzimListAdapter);
        rvZzim.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvZzim.setEmptyView(tvEmpty);

        tvZzimTotalNum.setText(String.valueOf(mZzimListAdapter.getItemCount()));

//        btnZZimApplication.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Todo: api 연결
//
//            }
//        });

        cbZzimAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mZzimListAdapter.allSelectedZzim(b);
            }
        });

        //Dummy data
//        ZzimListItem item = new ZzimListItem();
//        item.setVoluntaryTime(4);
//        item.setVoluntaryPeriodStart("2015-12-03");
//        item.setVoluntaryPeriodEnd("2015-12-12");
//        item.setVoluntaryLocation("무관");
//        item.setVoluntaryOragination("");
//        item.setTitle("어린이 도서관 사서(오전)");
////        item.setSelected(false);
//
//        mZzimListItems.add(item);
//
//        mZzimListAdapter.setData(mZzimListItems);
    }

    @Override
    public void onListItemSelectedAll(boolean selected) {
        Log.d(TAG, " onListItemSelectedAll" + selected);
        cbZzimAll.setChecked(selected);
    }

    @Override
    public void onListItemDeleted() {
        tvZzimTotalNum.setText(String.valueOf(mZzimListAdapter.getItemCount()));
    }
}