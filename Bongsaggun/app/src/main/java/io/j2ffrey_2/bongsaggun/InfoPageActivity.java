package io.j2ffrey_2.bongsaggun;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.model.Token;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class InfoPageActivity extends BaseActivity {

    public static final String TAG = InfoPageActivity.class.getSimpleName();
    public static final String TITLE = "voluntaryTitle";

    private int voluntaryId;
    private InfoItem item;

    @Bind(R.id.toolbar_infopage)
    Toolbar mToolbar;
    @Bind(R.id.toolbar_title)
    TextView tvTitle;

//    @Bind(R.id.fab_zzim)
//    FloatingActionButton fabZzim;

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

    @Bind(R.id.button_clerk_connection)
    Button btnClerkConnection;

    @Bind(R.id.button_zzim_application)
    Button btnZzimApplication;

    @Bind(R.id.button_zzim_cancel)
    Button btnZzimCancel;


//    @Bind(R.id.button_voluntary_application_top)
//    Button btnVoluntaryApplicationTop;
//
//    @Bind(R.id.button_voluntary_cancel_top)
//    Button btnVoluntaryCancelTop;
//
//    @Bind(R.id.button_voluntary_application_bottom)
//    Button btnVoluntaryApplicationBottom;
//
//    @Bind(R.id.button_voluntary_cancel_bottom)
//    Button btnVoluntaryCancelBottom;

    private boolean zzimFlag;
    private boolean applicationFlag;
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
        voluntaryId = getIntent().getIntExtra("voluntaryId", 0);

        Log.e(TAG, "id " + voluntaryId);

        if (voluntaryId != 0) {
            getInformation(voluntaryId);
        }
//        voluntaryTitle = intent.getStringExtra(TITLE);
//        voluntaryTitle = "유기견보호센터 봉사";

//        collapsingToolbar.setTitle(voluntaryTitle);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.MyCustomCollapsingToolbarTextAppearance);

//        fabZzim.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //Todo: 찜하기 api 연결
//                //Todo: 클릭시 버튼 바꾸기
//                zzimFlag = !zzimFlag;
//
//                Resources res = getResources();
//
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (zzimFlag) {  //찜 신청
//                        fabZzim.setBackgroundTintList(res.getColorStateList(R.color.InfoPage_fab_zzim_cancel, null));
//                        fabZzim.setImageDrawable(res.getDrawable(R.drawable.ic_check_teal_24dp, null));
//                    } else {  //찜 취소
//                        fabZzim.setBackgroundTintList(res.getColorStateList(R.color.InfoPage_fab_zzim_application, null));
//                        fabZzim.setImageDrawable(res.getDrawable(R.drawable.ic_check_white_24dp, null));
//                    }
//                } else {
//                    if (zzimFlag) {  //찜 신청
//                        fabZzim.setBackgroundTintList(res.getColorStateList(R.color.InfoPage_fab_zzim_cancel));
//                        fabZzim.setImageDrawable(res.getDrawable(R.drawable.ic_check_teal_24dp));
//                    } else {  //찜 취소
//                        fabZzim.setBackgroundTintList(res.getColorStateList(R.color.InfoPage_fab_zzim_application));
//                        fabZzim.setImageDrawable(res.getDrawable(R.drawable.ic_check_white_24dp));
//                    }
//                }
//
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//        loadImage(); //인텐트로 받은 객체 넘기기
//        loadData();  //인텐트로 받은 객체 넘기기
//        init();


        btnClerkConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 다이얼로그 띄우기

                final CharSequence[] items = {"E-mail주소 복사", "E-mail 보내기", "전화번호 복사", "전화걸기", "취소"};

                AlertDialog.Builder builder = new AlertDialog.Builder(InfoPageActivity.this);
                builder.setTitle("연락처");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int position) {
                        Intent intent;

                        switch (position) {
                            case 0:
                                if (item.getClerkEmail() != null) {
                                    ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("email", item.getClerkEmail());
                                    clipboardManager.setPrimaryClip(clipData);
                                    Toast.makeText(InfoPageActivity.this, "클립보드에 복사하였습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(InfoPageActivity.this, "담당자 E-mail이 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 1:
                                if (item.getClerkEmail() != null) {
                                    intent = new Intent(Intent.ACTION_SEND);
                                    intent.setType("message/rfc822");
                                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{item.getClerkEmail()});
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "문의드려요~!");
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(InfoPageActivity.this, "담당자 E-mail이 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 2:
                                if (item.getClerkCall() != null) {
                                    ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                                    ClipData clipData = ClipData.newPlainText("call", item.getClerkCall());
                                    clipboardManager.setPrimaryClip(clipData);
                                    Toast.makeText(InfoPageActivity.this, "클립보드에 복사하였습니다.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(InfoPageActivity.this, "담당자 전화번호가 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                            case 3:
                                if (item.getClerkCall() != null) {
                                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + item.getClerkCall()));
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(InfoPageActivity.this, "담당자 전화번호가 없습니다.", Toast.LENGTH_SHORT).show();
                                }
                                break;
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btnZzimApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 찜신청
            }
        });

        btnZzimCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Todo: 찜취소
            }
        });
    }

    private void loadImage() {

        if (!"null".equals(item.getImgMainUrl())) {
            Glide.with(this).
                    load(item.getImgMainUrl())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_logo)
                    .crossFade()
                    .into(ivBackdrop);
        } else {
            Glide.with(this).
                    load(R.mipmap.ic_logo)
                    .centerCrop()
                    .crossFade()
                    .into(ivBackdrop);
        }

        if (!"null".equals(item.getImgPosterUrl())) {
            Glide.with(this).
                    load(item.getImgPosterUrl())
                    .centerCrop()
                    .placeholder(R.mipmap.ic_logo)
                    .crossFade()
                    .into(ivPoster);
        } else {
            Glide.with(this).
                    load(R.mipmap.ic_logo)
                    .centerCrop()
                    .crossFade()
                    .into(ivPoster);
        }
    }

    //Todo: DB에서 Data load
    private void loadData() {
        collapsingToolbar.setTitle(item.getTitle());
        tvMainInfoRecruitmentPeriodStart.setText(item.getVoluntaryDateRecruitStart());
        tvMainInfoRecruitmentPeriodEnd.setText(item.getVoluntaryDateRecruitEnd());
        tvMainInfoVoluntaryTime.setText(item.getVoluntaryTime() + "시간");
        tvMainInfoVoluntaryDday.setText("8");
        tvMainInfoVoluntaryLocation.setText(item.getRegion());

        if (item.isApproval()) {
            tvMainInfoVoluntaryAuth.setText("가능");
        } else {
            tvMainInfoVoluntaryAuth.setText("불가능");
        }

        tvDetailInfoDetails.setText(item.getTitle());

        tvDetailInfoVoluntaryPeriodStart.setText(item.getVoluntaryDateRealStart());
        tvDetailInfoVoluntaryPeriodEnd.setText(item.getVoluntaryDateRealEnd());
        tvDetailInfoSupportCondition.setText(item.getRequirement());
        tvDetailInfoSupportGender.setText("남녀무관");
        tvDetailInfoContact.setText(item.getClerkEmail());
        tvDetailInfoLocation.setText(item.getAddress());
    }

    private void init() {
        zzimFlag = false;
        applicationFlag = false;

        VoluntaryButtonListener voluntaryButtonListener = new VoluntaryButtonListener();

//        btnVoluntaryApplicationTop.setOnClickListener(voluntaryButtonListener);
//        btnVoluntaryCancelTop.setOnClickListener(voluntaryButtonListener);
//        btnVoluntaryApplicationBottom.setOnClickListener(voluntaryButtonListener);
//        btnVoluntaryCancelBottom.setOnClickListener(voluntaryButtonListener);
    }

    class VoluntaryButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            applicationFlag = !applicationFlag;

//            switch (view.getId()){
//                case R.id.button_voluntary_application_top:  //Todo: 신청하기
//                case R.id.button_voluntary_application_bottom:
//
//                    btnVoluntaryApplicationTop.setVisibility(View.GONE);
//                    btnVoluntaryCancelTop.setVisibility(View.VISIBLE);
//                    btnVoluntaryApplicationBottom.setVisibility(View.GONE);
//                    btnVoluntaryCancelBottom.setVisibility(View.VISIBLE);
//
//                    break;
//                case R.id.button_voluntary_cancel_top:   //Todo: 신청취소
//                case R.id.button_voluntary_cancel_bottom:
//
//                    btnVoluntaryApplicationTop.setVisibility(View.VISIBLE);
//                    btnVoluntaryCancelTop.setVisibility(View.GONE);
//                    btnVoluntaryApplicationBottom.setVisibility(View.VISIBLE);
//                    btnVoluntaryCancelBottom.setVisibility(View.GONE);
//                    break;
//            }
            Log.i(TAG, " " + applicationFlag);
        }
    }

    public void getInformation(int voluntaryId) {

        Call<JsonObject> call = requestHelper.getInfoPage(voluntaryId);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Response<JsonObject> response, Retrofit retrofit) {

                JsonObject jsonObject = response.body();

                if (jsonObject != null) {

                    Log.d(TAG, " jsonObject is " + jsonObject);

                    Token token = new Gson().fromJson(jsonObject.getAsJsonObject("Token"), Token.class);

                    if (token.getStatus() == 200) {  //데이터 얻기 성공
                        item = new Gson().fromJson(jsonObject.getAsJsonObject("Bongsa"), InfoItem.class);

                        loadData();
                        loadImage();
                    } else {

                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, " Throwable is " + t);
            }
        });
    }
}
