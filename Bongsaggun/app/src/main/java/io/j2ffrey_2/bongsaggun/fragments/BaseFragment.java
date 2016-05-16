package io.j2ffrey_2.bongsaggun.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import io.j2ffrey_2.bongsaggun.activities.BaseActivity;
import io.j2ffrey_2.bongsaggun.network.BackendHelper;

/**
 * Created by Dong on 2015-11-27.
 */
public class BaseFragment extends Fragment {

    private BaseActivity hostActivity;

    protected static BackendHelper requestHelper;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof BaseActivity){
            hostActivity = (BaseActivity)context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }
    }
}
