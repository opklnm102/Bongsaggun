package io.j2ffrey_2.bongsaggun.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.j2ffrey_2.bongsaggun.R;
import io.j2ffrey_2.bongsaggun.models.SearchListItem;
import io.j2ffrey_2.bongsaggun.events.BusProvider;
import io.j2ffrey_2.bongsaggun.events.EventSearchResult;
import io.j2ffrey_2.bongsaggun.views.RecyclerViewEmptySupport;
import io.j2ffrey_2.bongsaggun.views.adapters.SearchListAdapter;


public class SearchListFragment extends BaseFragment {

    public static final String TAG = SearchListFragment.class.getSimpleName();

    @Bind(R.id.recyclerView_search)
    RecyclerViewEmptySupport rvSearchList;

    @Bind(R.id.textView_empty_search)
    TextView tvEmpty;

    SearchListAdapter mSearchListAdapter;

    private ArrayList<SearchListItem> mSearchListItems;

    public static SearchListFragment newInstance() {
        SearchListFragment fragment = new SearchListFragment();
        return fragment;
    }

    public SearchListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.e(TAG, " onCreate");
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onDestroy() {
        BusProvider.getInstance().unregister(this);
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_list, container, false);
        ButterKnife.bind(this, view);
        Log.e(TAG, " onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e(TAG, " onViewCreated");
        mSearchListItems = new ArrayList<>();

        mSearchListAdapter = new SearchListAdapter(getActivity(), mSearchListItems);

        rvSearchList.setAdapter(mSearchListAdapter);
        rvSearchList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSearchList.setEmptyView(tvEmpty);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, " onResume");
    }

    @Subscribe
    public void getSearchList(EventSearchResult event){
        mSearchListAdapter.setData(event.getSearchListItems());
    }
}
