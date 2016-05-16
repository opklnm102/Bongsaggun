package io.j2ffrey_2.bongsaggun.events;

import io.j2ffrey_2.bongsaggun.models.SearchParameter;

/**
 * Created by Dong on 2015-12-04.
 */
public class EventSearchStart {

    private SearchParameter searchParameter;

    public EventSearchStart(){
    }

    public EventSearchStart(SearchParameter searchParameter){
        this.searchParameter = searchParameter;
    }

    public SearchParameter getSearchParameter() {
        return searchParameter;
    }
}
