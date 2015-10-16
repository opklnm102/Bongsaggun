package io.j2ffrey_2.bongsaggun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InfoPageActivity extends AppCompatActivity {

    public static final String TAG = "InfoPageActivity";
    public static final String TITLE = "voluntaryTitle";

    @Bind(R.id.toolbar_infopage)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView tvTitle;
    @Bind(R.id.fab_zzim)
    FloatingActionButton fabZzim;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.imageView_backdrop)
    ImageView ivBackdrop;

    @Bind(R.id.textView_mainInfo_recruitmentPeriod_start)
    TextView tvMainInfoRecruitmentPeriodStart;

    @Bind(R.id.textView_mainInfo_recruitmentPeriod_end)
    TextView tvMainInfoRecruitmentPeriodEnd;

    @Bind(R.id.textView_mainInfo_voluntary_time_content)
    TextView tvMainInfoVoluntaryTime;

    @Bind(R.id.textView_mainInfo_voluntary_dDay_content)
    TextView tvMainInfoVoluntaryDday;

    @Bind(R.id.textView_mainInfo_voluntary_location_content)
    TextView tvMainInfoVoluntaryLocation;

    @Bind(R.id.textView_mainInfo_voluntary_auth_content)
    TextView tvMainInfoVoluntaryAuth;

    @Bind(R.id.textView_detailInfo_details_content)
    TextView tvDetailInfoDetails;

    @Bind(R.id.textView_detailInfo_voluntaryPeriod_start)
    TextView tvDetailInfoVoluntaryPeriodStart;

    @Bind(R.id.textView_detailInfo_voluntaryPeriod_end)
    TextView tvDetailInfoVoluntaryPeriodEnd;

    @Bind(R.id.textView_detailInfo_supportCondition_content)
    TextView tvDetailInfoSupportCondition;

    @Bind(R.id.textView_detailInfo_supportGender_content)
    TextView tvDetailInfoSupportGender;

    @Bind(R.id.textView_detailInfo_contact_content)
    TextView tvDetailInfoContact;

    @Bind(R.id.textView_detailInfo_location_content)
    TextView tvDetailInfoLocation;

    @Bind(R.id.imageView_poster)
    ImageView ivPoster;

    @Bind(R.id.button_voluntary_application_top)
    Button btnVoluntaryApplicationTop;

    @Bind(R.id.button_voluntary_application_bottom)
    Button btnVoluntaryApplicationBottom;

    private String voluntaryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        Log.e(TAG, " onCreate");

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }

        //Todo: 객체 받기
        Intent intent = getIntent();
//        voluntaryTitle = intent.getStringExtra(TITLE);
        voluntaryTitle = "유기견보호센터 봉사";

        collapsingToolbar.setTitle(voluntaryTitle);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.MyCustomCollapsingToolbarTextAppearance);

        fabZzim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 찜하기 api 연결
                //Todo: 클릭시 버튼 바꾸기
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        loadBackdrop(); //인텐트로 받은 객체 넘기기
        loadData();  //인텐트로 받은 객체 넘기기

         btnVoluntaryApplicationTop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Todo: 신청하기
             }
         });
         btnVoluntaryApplicationBottom.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //Todo: 신청하기
             }
         });
    }

    private void loadBackdrop() {
//        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(ivBackdrop);
        ivBackdrop.setImageResource(R.drawable.cheese_1);
    }

    //Todo: DB에서 Data load
    private void loadData(){
         tvMainInfoRecruitmentPeriodStart.setText("2015-08-22");
         tvMainInfoRecruitmentPeriodEnd.setText("2015-08-24");
         tvMainInfoVoluntaryTime.setText("12시간");
        tvMainInfoVoluntaryDday.setText("8");
         tvMainInfoVoluntaryLocation.setText("서울 서초구");
         tvMainInfoVoluntaryAuth.setText("가능");
         tvDetailInfoDetails.setText("유기견과 함께 사랑을 나누는 힐링 봉사활동");
         tvDetailInfoVoluntaryPeriodStart.setText("2015-10-16");
         tvDetailInfoVoluntaryPeriodEnd.setText("2015-10-18");
         tvDetailInfoSupportCondition.setText("20대, 알러지 없으신 분");
         tvDetailInfoSupportGender.setText("남녀무관");
         tvDetailInfoContact.setText("Yoofdkffdfdsf@seoul.go.kr");
         tvDetailInfoLocation.setText("서울시 서초구 반포3동 324-1");

         ivPoster.setImageResource(R.drawable.cheese_2);
//        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(ivPoster);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, " onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, " onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, " onResume");
    }
}
