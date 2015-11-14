package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZzimFragment extends Fragment implements ZzimListAdapter.selectedAllCallback {

    public static final String TAG = "ZzimFragment";

    @Bind(R.id.textView_zzim_total_num)
    TextView tvZzimTotalNum;
    @Bind(R.id.button_zzim_application)
    Button btnZZimApplication;
    @Bind(R.id.checkbox_zzim_all)
    CheckBox cbZzimAll;
    @Bind(R.id.recyclerView_zzim)
    RecyclerView rvZzim;

    ZzimListAdapter adapter;



    public static ZzimFragment newInstance() {
        ZzimFragment fragment = new ZzimFragment();

        return fragment;
    }

    public ZzimFragment() {
        // Required empty public constructor
    }

    //getdata
    public static List<ZzimListItem> getData() {
        List<ZzimListItem> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");

        for (int i = 0; i < 2; i++) {
            ZzimListItem current = new ZzimListItem();
            current.setTitle("유기견보호센터 봉사");
            current.setSelected(false);
            current.setVoluntaryLocation("서울 서초구");
            current.setVoluntaryOragination("한국동물협회");
            current.setVoluntaryPeriodEnd("2015.03.09");
            current.setVoluntaryPeriodStart("2015.04.10");
            current.setVoluntaryTime(12);

            data.add(current);
        }

        return data;
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


        adapter = new ZzimListAdapter(getActivity(), this, getData());
        rvZzim.setAdapter(adapter);
        rvZzim.setLayoutManager(new LinearLayoutManager(getActivity()));

        tvZzimTotalNum.setText(String.valueOf(adapter.getItemCount()));

        btnZZimApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: api 연결

            }
        });

        cbZzimAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                adapter.allSelectedZzim(b);
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSelectedAll(boolean selected) {
        Log.e(TAG, " onSelectedAll" + selected);
        cbZzimAll.setChecked(selected);
    }
}
