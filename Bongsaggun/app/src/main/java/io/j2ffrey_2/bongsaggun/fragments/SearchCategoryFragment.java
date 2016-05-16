package io.j2ffrey_2.bongsaggun.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.events.BusProvider;
import io.j2ffrey_2.bongsaggun.events.EventSearchStart;
import io.j2ffrey_2.bongsaggun.models.SearchParameter;

public class SearchCategoryFragment extends BaseFragment implements View.OnClickListener {

    public static final String TAG = SearchCategoryFragment.class.getSimpleName();

    @Bind(R.id.container_category)
    RelativeLayout rlayoutCategory;
    @Bind(R.id.container_region)
    RelativeLayout rlayoutRegion;
    @Bind(R.id.container_school)
    RelativeLayout rlayoutSchool;
    @Bind(R.id.container_time)
    RelativeLayout rlayoutTime;
    @Bind(R.id.button_search_start)
    Button btnSearchStart;
    @Bind(R.id.button_search_category_init)
    Button btnSearchCategoryInit;
    @Bind(R.id.textView_category)
    TextView tvCategory;
    @Bind(R.id.textView_region)
    TextView tvRegion;
    @Bind(R.id.textView_school)
    TextView tvSchool;
    @Bind(R.id.textView_time)
    TextView tvTime;

    //검색용 id
    int categoryId;
    int regionId;
    int schoolId;
    int timeId;

    //Todo: DB에 저장해서 불러오기 -> DB업뎃될 때마다 수정할 수 없으니, 자동으로 갱신되게 api 받아서
    final String strCategory[] = new String[]{"노력봉사", "교육봉사", "재능봉사", "해외봉사", "기타봉사"};
    final String strRegion[] = new String[]{"무관", "강동구", "강남구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구",
            "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구",
            "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구", "해외"};
    final String strSchool[] = new String[]{"무관", "서울교육대학교", "서울대학교", "서울과학기술대학교", "육군사관학교",
            "한국방송통신대학교", "한국예술종합학교", "한국체육대학교", "KAIST(경영)", "서울시립대학교", "가톨릭대학교",
            "감리교신학대학교", "건국대학교", "경기대학교", "경희대학교", "고려대학교", "광운대학교", "국민대학교", "그리스도대학교",
            "덕성여자대학교", "동국대학교", "동덕여자대학교", "명지대학교", "삼육대학교", "상명대학교", "서강대학교", "서경대학교",
            "서울기독대학교", "서울여자대학교", "성공회대학교", "성균관대학교", "성신여자대학교", "세종대학교", "숙명여자대학교"
            , "숭실대학교", "연세대학교", "이화여자대학교", "장로회신학대학교", "중앙대학교", "총신대학교", "추계예술대학교",
            "한국성서대학교", "한국외국어대학교", "한성대학교", "한양대학교", "한영신학대학교", "홍익대학교"};
    final String strTime[] = new String[]{"1~3시간", "4~7시간", "8시간"};

    public static SearchCategoryFragment newInstance() {
        SearchCategoryFragment fragment = new SearchCategoryFragment();
        return fragment;
    }

    public SearchCategoryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_category, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchConditionInit();
    }

    @OnClick({R.id.container_category, R.id.container_region, R.id.container_school, R.id.container_time, R.id.button_search_start, R.id.button_search_category_init})
    @Override
    public void onClick(View view) {

        View viewTitle = LayoutInflater.from(getActivity()).inflate(R.layout.alert_dialog_title, null);
        TextView tvTitle = (TextView) viewTitle.findViewById(R.id.textView_title);

        switch (view.getId()) {
            case R.id.container_category:
                DialogInterface.OnClickListener listenerCategoryDialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case AlertDialog.BUTTON_POSITIVE:
                                break;
                            case AlertDialog.BUTTON_NEGATIVE:
                                break;
                            default:
                                // Toast.makeText(BookPageActivity.this, "Which : " + which, Toast.LENGTH_LONG).show();
                                categoryId = which;
                                tvCategory.setText(strCategory[categoryId]);
                        }
                    }
                };

                tvTitle.setText("종류 선택");
                new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle)
                        .setCustomTitle(viewTitle)
                        .setSingleChoiceItems(strCategory, -1, listenerCategoryDialog)
                        .setPositiveButton("확인", listenerCategoryDialog)
                        .setNegativeButton("취소", listenerCategoryDialog)
                        .show();
                break;
            case R.id.container_region:
                DialogInterface.OnClickListener listenerRegionDialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case AlertDialog.BUTTON_POSITIVE:
                                break;
                            case AlertDialog.BUTTON_NEGATIVE:
                                break;
                            default:
                                // Toast.makeText(BookPageActivity.this, "Which : " + which, Toast.LENGTH_LONG).show();
                                regionId = which;
                                tvRegion.setText(strRegion[regionId]);
                        }
                    }
                };

                tvTitle.setText("지역 선택");
                new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle)
                        .setCustomTitle(viewTitle)
                        .setSingleChoiceItems(strRegion, -1, listenerRegionDialog)
                        .setPositiveButton("확인", listenerRegionDialog)
                        .setNegativeButton("취소", listenerRegionDialog)
                        .show();
                break;
            case R.id.container_school:
                DialogInterface.OnClickListener listenerSchoolDialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case AlertDialog.BUTTON_POSITIVE:
                                break;
                            case AlertDialog.BUTTON_NEGATIVE:
                                break;
                            default:
                                // Toast.makeText(BookPageActivity.this, "Which : " + which, Toast.LENGTH_LONG).show();
                                schoolId = which;
                                tvSchool.setText(strSchool[schoolId]);
                        }
                    }
                };

                tvTitle.setText("학교 선택");
                new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle)
                        .setCustomTitle(viewTitle)
                        .setSingleChoiceItems(strSchool, -1, listenerSchoolDialog)
                        .setPositiveButton("확인", listenerSchoolDialog)
                        .setNegativeButton("취소", listenerSchoolDialog)
                        .show();
                break;
            case R.id.container_time:
                DialogInterface.OnClickListener listenerTimeDialog = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case AlertDialog.BUTTON_POSITIVE:
                                break;
                            case AlertDialog.BUTTON_NEGATIVE:
                                break;
                            default:
                                // Toast.makeText(BookPageActivity.this, "Which : " + which, Toast.LENGTH_LONG).show();
                                timeId = which;
                                tvTime.setText(strTime[timeId]);
                        }
                    }
                };

                tvTitle.setText("시간 선택");
                new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle)
                        .setCustomTitle(viewTitle)
                        .setSingleChoiceItems(strTime, -1, listenerTimeDialog)
                        .setPositiveButton("확인", listenerTimeDialog)
                        .setNegativeButton("취소", listenerTimeDialog)
                        .show();
                break;

            case R.id.button_search_start:  //Todo: 검색시작, 이벤트 날려서 프래그먼트 교체, + 데이터 요청

                final SearchParameter searchParameter = new SearchParameter();
                searchParameter.setCategoryId(categoryId + 1);
                searchParameter.setRegionId(regionId + 1);
                searchParameter.setSchoolId(schoolId + 1);
                searchParameter.setTimeId(timeId + 1);

//                EditText etSearch = (EditText)getActivity().findViewById(R.id.editText_search);
//                String strSearch = etSearch.getText().toString();
//                if( strSearch.length() > 0){
//                    searchParameter.setWord(strSearch);
//                }

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        BusProvider.getInstance().post(new EventSearchStart(searchParameter));
                    }
                });
                break;
            case R.id.button_search_category_init:  //검색 조건 초기화
                searchConditionInit();
                break;
        }
    }

    private void searchConditionInit() {
        //검색용 id 초기화
        categoryId = 0;
        regionId = 0;
        schoolId = 0;
        timeId = 0;

        //View 초기화
        tvCategory.setText(strCategory[categoryId]);
        tvRegion.setText(strRegion[regionId]);
        tvSchool.setText(strSchool[schoolId]);
        tvTime.setText(strTime[timeId]);
    }
}
