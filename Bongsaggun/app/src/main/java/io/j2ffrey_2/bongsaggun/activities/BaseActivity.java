package io.j2ffrey_2.bongsaggun.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import io.j2ffrey_2.bongsaggun.BongsaggunApplication;
import io.j2ffrey_2.bongsaggun.database.BongsaggunContracts;
import io.j2ffrey_2.bongsaggun.BuildConfig;
import io.j2ffrey_2.bongsaggun.network.BackendHelper;

/**
 * Created by han on 2015-11-01.
 */
//Todo: 인터넷 연결 체크
public class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();

    protected Tracker mTracker;

    protected static BackendHelper requestHelper;
    protected static SharedPreferences sSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(requestHelper == null){
            requestHelper = BackendHelper.getInstance();
        }

        if(sSharedPreferences == null){
            sSharedPreferences = getSharedPreferences(BongsaggunContracts.PREFERENCE_NAME, Context.MODE_PRIVATE);
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

    public void onError(Exception e){
        onError(e);

        if(BuildConfig.DEBUG){
            e.printStackTrace();
        }
    }

    //유저 id 가져오기
    protected int getPreferenceUid(){
        return sSharedPreferences.getInt(BongsaggunContracts.PREFERENCE_KEY_USER_ID, 0);
    }

    //유저 id 저장
    protected void putPreferenceUid(int id){
        sSharedPreferences.edit().putInt(BongsaggunContracts.PREFERENCE_KEY_USER_ID, id)
                .apply();
    }

    //정보제거
    protected void clearPreference(){
        sSharedPreferences.edit().clear().apply();
    }
}
