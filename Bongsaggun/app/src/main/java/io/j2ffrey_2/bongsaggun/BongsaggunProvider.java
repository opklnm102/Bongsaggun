package io.j2ffrey_2.bongsaggun;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import java.util.Arrays;

/**
 * Created by han on 2015-10-29.
 */
public class BongsaggunProvider extends ContentProvider {

    public static final String TAG = BongsaggunProvider.class.getSimpleName();

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private BongsaggunDbHelper mOpenHelper;

    //URI Matcher를 위한 상수
    private static final int SCHOOL = 100;
    private static final int REGION = 200;
    private static final int IMAGE = 300;
    private static final int VOLUNTARY = 400;

    private static final SQLiteQueryBuilder sVoluntarySettingQueryBuilder;

    static {
        sVoluntarySettingQueryBuilder = new SQLiteQueryBuilder();

        //Voluntary LEFT OUTER JOIN Region ON Region.id=Voluntary.regioinId
        //LEFT OUTER JOIN School ON School.id=Voluntary.schoolId
        //LEFT OUTER JOIN Image ON Image .id=Voluntary.ImageId
        sVoluntarySettingQueryBuilder.setTables(BongsaggunContract.VoluntaryEntry.TABLE_NAME +
                        " LEFT OUTER JOIN " + BongsaggunContract.RegionEntry.TABLE_NAME +
                        "ON " + BongsaggunContract.RegionEntry.TABLE_NAME + "." + BongsaggunContract.RegionEntry.COLUMN_REGION_ID +
                        "=" + BongsaggunContract.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID +
                        " LEFT OUTER JOIN " + BongsaggunContract.SchoolEntry.TABLE_NAME +
                        "ON " + BongsaggunContract.SchoolEntry.TABLE_NAME + "." + BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_ID +
                        "=" + BongsaggunContract.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID +
                        " LEFT OUTER JOIN " + BongsaggunContract.ImageEntry.TABLE_NAME +
                        "ON " + BongsaggunContract.ImageEntry.TABLE_NAME + "." + BongsaggunContract.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID +
                        "=" + BongsaggunContract.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID
        );
    }

    //query문 작성(where절, 앞에 부분)

    //image update할 때 사용
    //voluntary.voluntary_mainImageId = ?
    private static final String imageSelection =
            BongsaggunContract.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + "= ?";

//    private Cursor getVoluntaryInformation(Uri uri, String[] projection, String sortOrder) {
//        String locationSetting = WeatherContract.WeatherEntry.getLocationSettingFromUri(uri);
//        long startDate = WeatherContract.WeatherEntry.getStartDateFromUri(uri);
//
//        String[] selectionArgs;
//        String selection;
//
//        if (startDate == 0) {
//            selection = sLocationSettingSelection;
//            selectionArgs = new String[]{locationSetting};
//        } else {
//            selectionArgs = new String[]{locationSetting, Long.toString(startDate)};
//            selection = sLocationSettingWithStartDateSelection;
//        }
//
//        return sVoluntarySettingQueryBuilder.query(
//                mOpenHelper.getReadableDatabase(),  //DB
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                sortOrder
//        );
//    }


    @Override
    public boolean onCreate() {
        mOpenHelper = new BongsaggunDbHelper(getContext());
        return true;
    }

    private void deleteDatabase(){
        mOpenHelper.close();
        Context context = getContext();
        BongsaggunDbHelper.deleteDatabase(context);
        mOpenHelper = new BongsaggunDbHelper(getContext());
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        final int match = sUriMatcher.match(uri);

        switch (match) {
            case SCHOOL:
                return BongsaggunContract.SchoolEntry.CONTENT_TYPE;
            case REGION:
                return BongsaggunContract.RegionEntry.CONTENT_TYPE;
            case IMAGE:
                return BongsaggunContract.ImageEntry.CONTENT_TYPE;
            case VOLUNTARY:
                return BongsaggunContract.VoluntaryEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Cursor retCursor;
        final SQLiteDatabase db = mOpenHelper.getReadableDatabase();

        Log.d(TAG, "uri=" + uri + " code=" + sUriMatcher.match(uri) + " proj=" +
                Arrays.toString(projection) + " selection=" + selection + " args="
                + Arrays.toString(selectionArgs) + ")");

        //uri객체를 통해 원하는 요청이 무엇인지 검사
        switch (sUriMatcher.match(uri)) {
            // "school"
            case SCHOOL: {
                if(TextUtils.isEmpty(sortOrder)){  //정렬값이 없다면 id를 기준으로 정렬
                    sortOrder = BongsaggunContract.SchoolEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = db.query(
                        BongsaggunContract.SchoolEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            // "region"
            case REGION: {
                retCursor = db.query(
                        BongsaggunContract.RegionEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            // "image"
            case IMAGE: {
                retCursor = db.query(
                        BongsaggunContract.ImageEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            // "voluntary"
            case VOLUNTARY: {
                retCursor = db.query(
                        BongsaggunContract.VoluntaryEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            // "voluntary/*/*"
//            case VOLUNTARY: {
//                retCursor = getfdf(uri, projection, sortOrder);
//                break;
//            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        retCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return retCursor;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        Uri returnUri;

        switch (match) {
            case SCHOOL: {
                long _id = db.insert(BongsaggunContract.SchoolEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContract.SchoolEntry.buildSchoolUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case REGION: {
                long _id = db.insert(BongsaggunContract.RegionEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContract.RegionEntry.buildRegionUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IMAGE: {
                long _id = db.insert(BongsaggunContract.ImageEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContract.ImageEntry.buildImageUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case VOLUNTARY: {
                long _id = db.insert(BongsaggunContract.VoluntaryEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContract.VoluntaryEntry.buildVoluntaryUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsDeleted;

        if (null == selection) selection = "1";
        switch (match) {
            case SCHOOL:
                rowsDeleted = db.delete(
                        BongsaggunContract.SchoolEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case REGION:
                rowsDeleted = db.delete(
                        BongsaggunContract.RegionEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case IMAGE:
                rowsDeleted = db.delete(
                        BongsaggunContract.ImageEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsDeleted = db.delete(
                        BongsaggunContract.VoluntaryEntry.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }

        if (rowsDeleted != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsDeleted;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int rowsUpdated;

        switch (match) {
            case SCHOOL:
                rowsUpdated = db.update(
                        BongsaggunContract.SchoolEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case REGION:
                rowsUpdated = db.update(
                        BongsaggunContract.RegionEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case IMAGE:
                rowsUpdated = db.update(
                        BongsaggunContract.ImageEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsUpdated = db.update(
                        BongsaggunContract.VoluntaryEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
        if (rowsUpdated != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return rowsUpdated;
    }

    //Uri Matcher를 준비
    static UriMatcher buildUriMatcher() {

        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = BongsaggunContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, BongsaggunContract.PATH_SCHOOL, SCHOOL);
//        matcher.addURI(authority, VoluntaryContract.PATH_SCHOOL, + "/*", );

        matcher.addURI(authority, BongsaggunContract.PATH_REGION, REGION);
        matcher.addURI(authority, BongsaggunContract.PATH_IMAGE, IMAGE);
        matcher.addURI(authority, BongsaggunContract.PATH_VOLUNTARY, VOLUNTARY);

        return matcher;
    }

    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        final int match = sUriMatcher.match(uri);
        int returnCount = 0;

        switch (match) {
            case SCHOOL:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContract.SchoolEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            case REGION:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContract.RegionEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            case IMAGE:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContract.ImageEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            case VOLUNTARY:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContract.VoluntaryEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            default:
                return super.bulkInsert(uri, values);
        }
        if (returnCount != 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return returnCount;
    }
}
