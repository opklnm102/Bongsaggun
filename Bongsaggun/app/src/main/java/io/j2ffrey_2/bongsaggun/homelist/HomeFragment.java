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

    public static final String TAG = HomeFragment.class.getSimpleName();

    //Todo: 보여줘야 할것, 메인이미지, 제목, 모집기간 시작, 종료, 봉사시간, 지역, D-day(모집마감부터 계산)
    private static final int HOMELIST_LOADER = 0;
    private static final String[] HOMELIST_COLUMNS = {
            BongsaggunContract.VoluntaryEntry._ID,  //쿼리용
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID,  //쿼리용
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE,  //제목
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START,  //모집기간 시작
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END,  //모집기간 종료
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL,  //메인 이미지
            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME,  //봉사시간

            BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID,  //지역
            //d-day는 모집마감일부터 계산
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
