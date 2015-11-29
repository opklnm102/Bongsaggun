package io.j2ffrey_2.bongsaggun.homelist;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.BaseFragment;
import io.j2ffrey_2.bongsaggun.BongsaggunContract;
import io.j2ffrey_2.bongsaggun.CalendarItem;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.model.Token;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeFragment extends BaseFragment {

    public static final String TAG = HomeFragment.class.getSimpleName();
    //Todo: 레이아웃 조정

    @Bind(R.id.recyclerView_home)
    RecyclerView rvHomeList;

    HomeListAdapter mHomeListAdapter;

    private ArrayList<HomeListItem> mHomeListItemArrayList;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mHomeListItemArrayList = new ArrayList<>();

        mHomeListAdapter = new HomeListAdapter(getActivity(), mHomeListItemArrayList);

        rvHomeList.setAdapter(mHomeListAdapter);
        rvHomeList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onResume() {
        super.onResume();

        getHomeList(10);
    }

    public void getHomeList(int voluntaryId, int limit) {

        mHomeListItemArrayList = new ArrayList<>();

        Call<JsonObject> call = requestHelper.getHomeList(voluntaryId, limit);
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
                            HomeListItem item = new Gson().fromJson(jsonArray.get(i), HomeListItem.class);
                            mHomeListItemArrayList.add(item);
                            Log.e(TAG, " " + item.getVoluntaryId() + item.getdDay() + item.getRegion() + item.getTitle() + item.getVoluntaryTime() + item.getVoluntaryDateRecruitStart() + item.getVoluntaryDateRecruitEnd() + item.getImgMainUrl());
                        }
                    } else {
                        Log.e(TAG, " " + mHomeListItemArrayList.size());

                    }
                    mHomeListAdapter.setData(mHomeListItemArrayList);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, " Throwable is " + t);
            }
        });
    }

    public void getHomeList(int limit) {

        mHomeListItemArrayList = new ArrayList<>();

        Call<JsonObject> call = requestHelper.getHomeList(limit);
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
                            HomeListItem item = new Gson().fromJson(jsonArray.get(i), HomeListItem.class);
                            mHomeListItemArrayList.add(item);
                            Log.e(TAG, " " + item.getVoluntaryId() + item.getdDay() + item.getRegion() + item.getTitle() + item.getVoluntaryTime() + item.getVoluntaryDateRecruitStart() + item.getVoluntaryDateRecruitEnd() + item.getImgMainUrl());
                        }
                    } else {
                        Log.e(TAG, " " + mHomeListItemArrayList.size());

                    }
                    mHomeListAdapter.setData(mHomeListItemArrayList);
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e(TAG, " Throwable is " + t);
            }
        });
    }

}
