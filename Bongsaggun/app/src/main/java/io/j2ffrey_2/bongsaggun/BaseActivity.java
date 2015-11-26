package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by han on 2015-11-01.
 */
//Todo: 인터넷 연결 체크
public class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    protected Tracker mTracker;

    protected static BackendHelper requestHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }

        BongsaggunApplication application = (BongsaggunApplication)getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Setting screen name: " + TAG);

        //send viewScreen name
        mTracker.setScreenName(TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        //Send an event
//        mTracker.send(new HitBuilders.EventBuilder()
//        .setCategory("Action")
//        .setAction("Share")
//        .build());
    }
}
