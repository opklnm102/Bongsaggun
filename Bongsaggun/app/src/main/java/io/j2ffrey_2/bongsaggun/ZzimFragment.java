package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ZzimFragment extends Fragment {

    public static final String TAG = "ZzimFragment";

    private RecyclerView recyclerView;
    private ZzimListAdapter adapter;

    public static ZzimFragment newInstance() {
        ZzimFragment fragment = new ZzimFragment();

        return fragment;
    }

    public ZzimFragment() {
        // Required empty public constructor
    }

    //getdata
    public static List<Zzim_list_contents> getData(){
        List<Zzim_list_contents> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");
        String[] titles = {"봉사꾼1" , "봉사꾼2" };
        //  String[] iconid = {"봉사꾼1" , "봉사꾼2" };
        for (int i=0; i<titles.length; i++){
            Zzim_list_contents current = new Zzim_list_contents();
            current.title = titles[i];
            current.IconId = R.mipmap.ic_launcher;
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

        recyclerView = (RecyclerView) view.findViewById(R.id.zzim_drawer_list);

        adapter = new ZzimListAdapter(getActivity(), getData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
