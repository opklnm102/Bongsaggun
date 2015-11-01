package io.j2ffrey_2.bongsaggun.homelist;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.j2ffrey_2.bongsaggun.MainActivity;
import io.j2ffrey_2.bongsaggun.NetworkManager;
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
    public List<Home_list_contents> getData(){
        List<Home_list_contents> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");
        String[] titles = {"유기견 봉사활동" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" };

        //네트워크 연결
        NetWorkActivity connector = new NetWorkActivity();
        connector.LoadAPI("https://dosomething-j2ffrey-2.c9.io/json/filter"); //주소 넣어서 받을 수 있게 바꾸기
        String s[][] = connector.getResult();

        for (int i=0; i<titles.length; i++){
            Home_list_contents current = new Home_list_contents();
            current.title = titles[i];


            current.IconId = R.mipmap.ic_launcher;
            data.add(current);
            current.IconId = R.mipmap.ic_launcher;

            //current.titleSet = s[1][5];

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
