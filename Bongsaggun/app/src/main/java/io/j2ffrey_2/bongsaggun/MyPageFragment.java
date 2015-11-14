package io.j2ffrey_2.bongsaggun;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MyPageFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = MyPageFragment.class.getSimpleName();

    @Bind(R.id.container_login)
    RelativeLayout rlayoutLogin;
    @Bind(R.id.container_myVoluntaryList)
    RelativeLayout rlayoutMyVoluntaryList;
    @Bind(R.id.container_zzimList)
    RelativeLayout rlayoutZzimList;
    @Bind(R.id.container_inquire)
    RelativeLayout rlayoutInquire;
    @Bind(R.id.container_aboutAs)
    RelativeLayout rlayoutAboutAs;
    @Bind(R.id.container_settings)
    RelativeLayout rlayoutSettings;
    @Bind(R.id.textView_myVoluntary_count)
    TextView tvMyVoluntaryCount;
    @Bind(R.id.textView_zzim_count)
    TextView tvZzimCount;
    @Bind(R.id.textView_name)
    TextView tvName;
    @Bind(R.id.imageView_profile)
    ImageView ivProfile;
    @Bind(R.id.textView_activity_Time)
    TextView tvActivityTime;

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
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initProfile();
    }

    //Todo: 로그인시 호출
    void initProfile() {
        setMyVoluntaryCount(2);
        setZzimCount(2);
        tvName.setText("Jeffery Lee");
        ivProfile.setImageResource(R.drawable.cheese_1);
        tvActivityTime.setText("33");
    }

    void setMyVoluntaryCount(int count) {
        tvMyVoluntaryCount.setText(count + "건");
    }

    void setZzimCount(int count) {
        tvZzimCount.setText(count + "건");
    }

    @OnClick({R.id.container_login, R.id.container_myVoluntaryList, R.id.container_zzimList, R.id.container_inquire, R.id.container_aboutAs, R.id.container_settings})
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.container_login:
                Log.d(TAG, " container_login");
                break;
            case R.id.container_myVoluntaryList:
                Log.d(TAG, " container_myVoluntaryList");
                break;
            case R.id.container_zzimList:
                Log.d(TAG, " container_zzimList");
                break;
            case R.id.container_inquire:
                Log.d(TAG, " container_inquire");
                break;
            case R.id.container_aboutAs:
                Log.d(TAG, " container_aboutAs");
                break;
            case R.id.container_settings:
                Log.d(TAG, " container_settings");
                break;
        }
    }
}