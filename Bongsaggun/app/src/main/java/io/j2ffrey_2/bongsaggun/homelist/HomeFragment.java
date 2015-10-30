package io.j2ffrey_2.bongsaggun.homelist;

import android.content.Intent;
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
    public static List<Home_list_contents> getData(){
        List<Home_list_contents> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");
        String[] titles = {"유기견 봉사활동" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2"
                , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" , "봉사꾼2" };



        for (int i=0; i<titles.length; i++){
            Home_list_contents current = new Home_list_contents();
            current.title = titles[i];

            //lala
            //String[][] st = current.getparsedata();
            //current.title = current.getparsedata()[0][3];
            //Log.i("st_ 배열 확인하기 " , st[0][3]);
            current.IconId = R.mipmap.ic_launcher;
            data.add(current);
            current.IconId = R.mipmap.ic_launcher;
            //current.titleSet = getparsedata()[1][3];


            try {
                JsonParser parser = new JsonParser();
                String[][] st;
                st = parser.jsonParserList();
                //current.titleSet = JsonParser.jsonParserList()[1][2];
            } catch (IOException e) {
                e.printStackTrace();
            }

            data.add(current);
        }

        return data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(android.os.Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(
                R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.drawer_list);

        adapter = new HomeListAdapter(getActivity(), getData()); //수정한부분 코드 다시보기 //ECEPTION

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

}
