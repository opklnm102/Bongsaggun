package io.j2ffrey_2.bongsaggun.homelist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.j2ffrey_2.bongsaggun.R;

public class HomeFragment extends Fragment {

    public static final String TAG = "HomeFragment";
    private RecyclerView recyclerView;
    private HomeListAdapter adapter;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {

    }

    //getdata
    public List<HomeListItem> getData() {
        List<HomeListItem> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");
        String[] titles = {"유기견 봉사활동", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"};

        for (int i = 0; i < titles.length; i++) {
            HomeListItem current = new HomeListItem();

            current.setTitle(titles[i]);
            current.setImgSumnail(R.mipmap.ic_launcher);
            current.setdDay(0);
            current.setVoluntaryPeriodStart("2015.3.13");
            current.setVoluntaryPeriodEnd("2015.3.20");
            current.setVoluntaryLocation("서울 서초구");
            current.setVoluntaryTime(13);

            data.add(current);
        }

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.drawer_list);

        adapter = new HomeListAdapter(getActivity(), getData());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
