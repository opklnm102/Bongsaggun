package io.j2ffrey_2.bongsaggun.event;

import java.util.ArrayList;

import io.j2ffrey_2.bongsaggun.SearchListItem;

/**
 * Created by Dong on 2015-12-05.
 */
public class EventSearchResult {

    private ArrayList<SearchListItem> mSearchListItems;

    public EventSearchResult(){
    }

    public EventSearchResult(ArrayList<SearchListItem> mSearchListItems){
        this.mSearchListItems = mSearchListItems;
    }

    public ArrayList<SearchListItem> getSearchListItems() {
        return mSearchListItems;
    }
}
