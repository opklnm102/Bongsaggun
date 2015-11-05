package io.j2ffrey_2.bongsaggun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by han on 2015-11-01.
 */
public class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
