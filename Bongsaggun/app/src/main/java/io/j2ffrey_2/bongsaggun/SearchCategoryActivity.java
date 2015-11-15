package io.j2ffrey_2.bongsaggun;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
            ab.setHomeAsUpIndicator(R.drawable.ic_search_white_24dp);
            //            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick({R.id.container_location, R.id.container_school, R.id.container_time, R.id.button_search_start, R.id.button_search_category_init})
    @Override
    public void onClick(View view) {

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case android.R.id.home:

                return true;
            case R.id.action_category_undo:
                Log.e(TAG, " category undo");

                finish();
                overridePendingTransition(0, 0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
