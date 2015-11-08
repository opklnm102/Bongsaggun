package io.j2ffrey_2.bongsaggun;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Dong on 2015-11-07.
 */
public class BongsaggunSyncService extends Service {

    public static final String TAG = BongsaggunSyncService.class.getSimpleName();

    private static final Object sSyncAdapterLock = new Object();
    private static BongsaggunSyncAdapter sBongsaggunSyncAdapter = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, " onCreate");
        synchronized (sSyncAdapterLock){
            if(sBongsaggunSyncAdapter == null){
                sBongsaggunSyncAdapter = new BongsaggunSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return sBongsaggunSyncAdapter.getSyncAdapterBinder();
    }
}
