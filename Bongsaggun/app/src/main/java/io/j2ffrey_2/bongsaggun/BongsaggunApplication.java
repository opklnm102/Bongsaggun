package io.j2ffrey_2.bongsaggun;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by han on 2015-11-01.
 */
public class BongsaggunApplication extends Application {

    private Tracker mTracker;

    synchronized public Tracker getDefaultTracker(){
        if(mTracker == null){
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            analytics.setLocalDispatchPeriod(1800);

            mTracker = analytics.newTracker("UA-69530268-1");
            mTracker.enableExceptionReporting(true);
            mTracker.enableAdvertisingIdCollection(true);
            mTracker.enableAutoActivityTracking(true);
        }
        return mTracker;
    }
}
