package io.j2ffrey_2.bongsaggun;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Dong on 2015-11-07.
 */
public class BongsaggunSyncAdapter extends AbstractThreadedSyncAdapter {

    public static final String TAG = BongsaggunSyncAdapter.class.getSimpleName();

    // Interval at which to sync with the voluntary, in seconds.
    // 60 seconds (1 minute) * 60 = 1 hours
    public static final int SYNC_INTERVAL = 60 * 60;
    public static final int SYNC_FLEXTIME = SYNC_INTERVAL/3;
    private static final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

    public BongsaggunSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {
        Log.d(TAG, " Start sync");

//        try {
//            NetworkManager.getInstance().getSchoolList();
//            NetworkManager.getInstance().getRegionList();
//            NetworkManager.getInstance().getAllVoluntaryList();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

//    public void insertSchoolData(Vector cVVector){
//
//        int inserted = 0;
//
//        //add to database
//        if(cVVector.size() > 0){
//            ContentValues[] cvArray = new ContentValues[cVVector.size()];
//            cVVector.toArray(cvArray);
//
//            getContext().getContentResolver().bulkInsert(VoluntaryContract.SchoolEntry.CONTENT_URI, cvArray);
//
//            //delete old data so we don't build up an endless history
//            //updateAt이 이전꺼는 지운다.
//            String updateAt = getContext().getContentResolver().query()
//
//            getContext().getContentResolver().delete(VoluntaryContract.SchoolEntry.CONTENT_URI, VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_UPDATEAT + " < ?",
//                    new String[] { updateAt });
//
//            notifySchool();
//        }
//
//        Log.d(TAG, " Sync Complete. " + cVVector.size() + " inserted");
//    }
//
//    private void notifySchool(){
//        Context context = getContext();
//
//    }









}
