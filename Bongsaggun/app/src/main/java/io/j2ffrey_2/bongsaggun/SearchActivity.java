package io.j2ffrey_2.bongsaggun;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.event.BusProvider;
import io.j2ffrey_2.bongsaggun.event.EventSearchResult;
import io.j2ffrey_2.bongsaggun.event.EventSearchStart;
import io.j2ffrey_2.bongsaggun.model.SearchParameter;
import io.j2ffrey_2.bongsaggun.model.Token;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SearchActivity extends BaseActivity {

    public static final String TAG = SearchActivity.class.getSimpleName();

    @Bind(R.id.toolbar_search)
    Toolbar mToolbar;
    @Bind(R.id.editText_search)
    EditText etSearch;

    FragmentManager fm;

    ArrayList<SearchListItem> mSearchListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
//            ab.setHomeAsUpIndicator(R.drawable.ic_search_white_24dp);
            ab.setDisplayShowTitleEnabled(false);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        BusProvider.getInstance().register(this);

        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction().add(R.id.container_fragment, fragment).commit();
        }
    }

    @Override
    protected void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    @Subscribe
    public void searchResult(EventSearchStart event) {

        final ProgressDialog progressDialog = new ProgressDialog(SearchActivity.this, ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("검색 중...");
        progressDialog.show();

        mSearchListItems = new ArrayList<>();

        SearchParameter searchParameter = event.getSearchParameter();

        String strSearch = etSearch.getText().toString();
        if (strSearch.length() > 0) {

            Call<JsonObject> call = requestHelper.getSearchList(strSearch, searchParameter.getCategoryId(), searchParameter.getRegionId(), searchParameter.getSchoolId(), searchParameter.getTimeId());
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Response<JsonObject> response, Retrofit retrofit) {

                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {

                        Log.d(TAG, " jsonObject is " + jsonObject);

                        Token token = new Gson().fromJson(jsonObject.getAsJsonObject("Token"), Token.class);

                        if (token.getStatus() == 200) {  //데이터 얻기 성공
                            JsonArray jsonArray = jsonObject.getAsJsonArray("Bongsa");

                            for (int i = 0; i < jsonArray.size(); i++) {
                                SearchListItem item = new Gson().fromJson(jsonArray.get(i), SearchListItem.class);
                                mSearchListItems.add(item);
                                Log.e(TAG, " " + item.getVoluntaryId() + " " + item.getdDay() + item.getRegion() + item.getTitle() + item.getVoluntaryTime() + item.getVoluntaryDateRecruitStart() + item.getVoluntaryDateRecruitEnd() + item.getImgMainUrl());
                            }
                        } else {
                            Log.e(TAG, " " + mSearchListItems.size());
                        }

                        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

                        if (fragment instanceof SearchCategoryFragment) {
                            fragment = SearchListFragment.newInstance();
                            fm.beginTransaction().replace(R.id.container_fragment, fragment).commit();
                        }

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                BusProvider.getInstance().post(new EventSearchResult(mSearchListItems));
                            }
                        });
                        progressDialog.hide();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e(TAG, " Throwable is " + t);
                }
            });
        } else {
            Call<JsonObject> call = requestHelper.getSearchList(searchParameter.getCategoryId(), searchParameter.getRegionId(), searchParameter.getSchoolId(), searchParameter.getTimeId());
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Response<JsonObject> response, Retrofit retrofit) {

                    JsonObject jsonObject = response.body();

                    if (jsonObject != null) {

                        Log.d(TAG, " jsonObject is " + jsonObject);

                        Token token = new Gson().fromJson(jsonObject.getAsJsonObject("Token"), Token.class);

                        if (token.getStatus() == 200) {  //데이터 얻기 성공
                            JsonArray jsonArray = jsonObject.getAsJsonArray("Bongsa");

                            for (int i = 0; i < jsonArray.size(); i++) {
                                SearchListItem item = new Gson().fromJson(jsonArray.get(i), SearchListItem.class);
                                mSearchListItems.add(item);
                                Log.e(TAG, " " + item.getVoluntaryId() + " " + item.getdDay() + item.getRegion() + item.getTitle() + item.getVoluntaryTime() + item.getVoluntaryDateRecruitStart() + item.getVoluntaryDateRecruitEnd() + item.getImgMainUrl());
                            }
                        } else {
                            Log.e(TAG, " " + mSearchListItems.size());
                        }

                        Fragment fragment = fm.findFragmentById(R.id.container_fragment);

                        if (fragment instanceof SearchCategoryFragment) {
                            fragment = SearchListFragment.newInstance();
                            fm.beginTransaction().replace(R.id.container_fragment, fragment).commit();
                        }

                        Handler handler = new Handler(Looper.getMainLooper());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                BusProvider.getInstance().post(new EventSearchResult(mSearchListItems));
                            }
                        });
                        progressDialog.hide();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e(TAG, " Throwable is " + t);
                }
            });
        }
    }

    public Fragment createFragment() {
        return SearchCategoryFragment.newInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_main, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_category);
//
//        SearchManager searchManager = (SearchManager) SearchMainActivity.this.getSystemService(Context.SEARCH_SERVICE);
//
//        SearchView searchView = null;
//        if (searchItem != null) {
//            searchView = (SearchView) searchItem.getActionView();
//        }
//        if (searchView != null) {
//            searchView.setSearchableInfo(searchManager.getSearchableInfo(SearchMainActivity.this.getComponentName()));
//        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
//            case android.R.id.home:
//
//                return true;
            case R.id.action_search:
                Log.e(TAG, " category");
//                Intent intent = new Intent(SearchActivity.this, SearchCategoryActivity.class);
//                startActivity(intent);
//                overridePendingTransition(0, 0);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
