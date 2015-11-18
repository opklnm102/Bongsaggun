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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.BongsaggunContract;
import io.j2ffrey_2.bongsaggun.R;

public class HomeFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    public static final String TAG = "HomeFragment";

    private static final int HOMELIST_LOADER = 0;
    private static final String[] HOMELIST_COLUMNS = {
            BongsaggunContract.VoluntaryEntry._ID,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_START,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_END,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIREMENT,
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME
    };

    @Bind(R.id.recyclerView_home)
    RecyclerView rvHomeList;

    HomeListAdapter mHomeListAdapter;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    public HomeFragment() {
    }

    //getdata
    public List<HomeListItem> getData() {
        List<HomeListItem> data = new ArrayList<>();
        Log.i("MyActivity", "MyClass.getView() — get item number ");
        String[] titles = {"유기견 봉사활동", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"
                , "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2", "봉사꾼2"};

        for (int i = 0; i < titles.length; i++) {
            HomeListItem current = new HomeListItem();

            current.setTitle(titles[i]);
            current.setImgSumnail(R.mipmap.ic_launcher);
            current.setdDay(0);
            current.setVoluntaryPeriodStart("2015.3.13");
            current.setVoluntaryPeriodEnd("2015.3.20");
            current.setVoluntaryLocation("서울 서초구");
            current.setVoluntaryTime(13);

            data.add(current);
        }

        return data;
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

        mHomeListAdapter = new HomeListAdapter(getActivity(), null);

        rvHomeList.setAdapter(mHomeListAdapter);
        rvHomeList.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        getLoaderManager().initLoader(HOMELIST_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {

        String sortOrder = BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + " DESC";

        return new CursorLoader(getActivity(),
                BongsaggunContract.VoluntaryEntry.CONTENT_URI,
                HOMELIST_COLUMNS,
                null,
                null,
                sortOrder);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
        mHomeListAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {
        mHomeListAdapter.swapCursor(null);
    }
}
