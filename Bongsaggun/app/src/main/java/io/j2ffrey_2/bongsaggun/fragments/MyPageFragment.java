package io.j2ffrey_2.bongsaggun.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;


import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.activities.SigninActivity;


public class MyPageFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = MyPageFragment.class.getSimpleName();

    @Bind(R.id.container_login)
    RelativeLayout rlayoutLogin;
    @Bind(R.id.container_myVoluntaryList)
    RelativeLayout rlayoutMyVoluntaryList;
    @Bind(R.id.container_zzimList)
    RelativeLayout rlayoutZzimList;
    @Bind(R.id.container_webSite)
    RelativeLayout rlayoutWebSitet;
    @Bind(R.id.container_inquire)
    RelativeLayout rlayoutInquire;
    @Bind(R.id.container_evaluation)
    RelativeLayout rlayoutEvaluation;
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
//    @Bind(R.id.imageView_profile)
//    ImageView ivProfile;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initProfile();  //Todo: 로그인시 호출
    }

    //Todo: 로그인시 호출
    void initProfile() {

        //Todo: 로그인시 분기 처리, 이미지 o,x
        //ivProfile.setImageResource(R.drawable.cheese_1);

        setMyVoluntaryCount(2);
        setZzimCount(2);
        tvName.setText("Jeffery Lee");
        tvActivityTime.setText("33");
    }

    void setMyVoluntaryCount(int count) {
        tvMyVoluntaryCount.setText(count + "건");
    }

    void setZzimCount(int count) {
        tvZzimCount.setText(count + "건");
    }

    @OnClick({R.id.container_login, R.id.container_myVoluntaryList, R.id.container_zzimList, R.id.container_webSite, R.id.container_inquire, R.id.container_evaluation, R.id.container_aboutAs, R.id.container_settings})
    @Override
    public void onClick(View view) {

        Intent intent;

        switch (view.getId()) {
            case R.id.container_login:  //로그인
                intent = new Intent(getActivity(), SigninActivity.class);
                startActivity(intent);
                break;
            case R.id.container_myVoluntaryList:  //나중에
                Log.d(TAG, " container_myVoluntaryList");
                break;
            case R.id.container_zzimList:  //나중에
                Log.d(TAG, " container_zzimList");
                break;
            case R.id.container_webSite:  //웹사이트로 연결, 암시적 인텐트
                intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://bongsaggun.com/");
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.container_inquire:  //메일 보내기, 암시적 인텐트
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"bongsaggun@naver.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "문의드려요~!");
                startActivity(intent);
                break;
            case R.id.container_evaluation:  //나중에
                Log.d(TAG, " container_evaluation");
                break;
            case R.id.container_aboutAs:  //나중에
                Log.d(TAG, " container_aboutAs");
                break;
            case R.id.container_settings:  //나중에
                Log.d(TAG, " container_settings");
                break;
        }
    }
}