package io.j2ffrey_2.bongsaggun.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.j2ffrey_2.bongsaggun.R;

public class SearchCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = SearchCategoryActivity.class.getSimpleName();

    @Bind(R.id.toolbar_search)
    Toolbar mToolbar;

    @Bind(R.id.container_location)
    RelativeLayout rlayoutLocation;
    @Bind(R.id.container_school)
    RelativeLayout rlayoutSchool;
    @Bind(R.id.container_time)
    RelativeLayout rlayoutTime;
    @Bind(R.id.button_search_start)
    Button btnSearchStart;
    @Bind(R.id.button_search_category_init)
    Button btnSearchCategoryInit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_category);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_detail_undo_24dp);
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick({R.id.container_location, R.id.container_school, R.id.container_time, R.id.button_search_start, R.id.button_search_category_init})
    @Override
    public void onClick(View view) {

        //Todo: 다이얼로그 열기
        switch (view.getId()) {
            case R.id.container_location:
                Log.d(TAG, " container_location");
                break;
            case R.id.container_school:
                Log.d(TAG, " container_school");
                break;
            case R.id.container_time:
                Log.d(TAG, " container_time");
                break;
            case R.id.button_search_start:
                Log.d(TAG, " button_search_start");
                break;
            case R.id.button_search_category_init:
                Log.d(TAG, " button_search_category_init");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_category, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
//            case android.R.id.home:
//
//                return true;
            case R.id.action_category_search:
                Log.e(TAG, " category undo");

                //Todo: 검색api 날리기

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
