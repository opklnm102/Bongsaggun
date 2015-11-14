package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;


public class MyPageFragment extends Fragment {


    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;
    LinearLayout myPageListViewLayout;


    public static MyPageFragment newInstance() {
        MyPageFragment fragment = new MyPageFragment();

        return fragment;
    }

    public MyPageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);


        myPageListViewLayout = (LinearLayout)view.findViewById(R.id.my_page_listview_container);



        arrayAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1
               );

        listView = (ListView) view.findViewById(R.id.my_page_listview);




        listView.setAdapter(arrayAdapter);


        arrayAdapter.add("로그인");
        arrayAdapter.add("로그인");
        arrayAdapter.add("로그인");
        arrayAdapter.add("로그인");




        listView.setOnItemClickListener(itemClickListenerOfList);


        return view;
    }



    private AdapterView.OnItemClickListener itemClickListenerOfList = new AdapterView.OnItemClickListener()
    {
        public void onItemClick(AdapterView<?> adapterView, View clickedView, int pos, long id)
        {

            if(id==0){

                arrayAdapter.clear();

                arrayAdapter.add("나의 봉사목록");
                arrayAdapter.add("찜한 봉사활동");
                arrayAdapter.add("문의");
                arrayAdapter.add("팀소개");
                arrayAdapter.add("설정");

                arrayAdapter.notifyDataSetChanged();

            }








        }
    };






}