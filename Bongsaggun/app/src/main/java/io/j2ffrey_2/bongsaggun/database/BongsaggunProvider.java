package io.j2ffrey_2.bongsaggun.database;

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
    private static final int TIME = 300;
    private static final int CATEGORY = 400;
    private static final int VOLUNTARY = 500;
    private static final int IMAGE = 600;

    private static final SQLiteQueryBuilder sVoluntarySettingQueryBuilder;

    static {
        sVoluntarySettingQueryBuilder = new SQLiteQueryBuilder();

        //Voluntary LEFT OUTER JOIN Region ON Region.id=Voluntary.regioinId
        //LEFT OUTER JOIN School ON School.id=Voluntary.schoolId
        //LEFT OUTER JOIN Image ON Image .id=Voluntary.ImageId
        sVoluntarySettingQueryBuilder.setTables(BongsaggunContracts.VoluntaryEntry.TABLE_NAME +
                        " LEFT OUTER JOIN " + BongsaggunContracts.RegionEntry.TABLE_NAME +
                        " ON " + BongsaggunContracts.RegionEntry.TABLE_NAME + "." + BongsaggunContracts.RegionEntry.COLUMN_REGION_ID +
                        " = " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID +

                        " LEFT OUTER JOIN " + BongsaggunContracts.SchoolEntry.TABLE_NAME +
                        " ON " + BongsaggunContracts.SchoolEntry.TABLE_NAME + "." + BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_ID +
                        " = " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID +

                        " LEFT OUTER JOIN " + BongsaggunContracts.TimeEntry.TABLE_NAME +
                        " ON " + BongsaggunContracts.TimeEntry.TABLE_NAME + "." + BongsaggunContracts.TimeEntry.COLUMN_TIME_ID +
                        " = " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID +

                        " LEFT OUTER JOIN " + BongsaggunContracts.CategoryEntry.TABLE_NAME +
                        " ON " + BongsaggunContracts.CategoryEntry.TABLE_NAME + "." + BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_ID +
                        " = " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID +

                        " LEFT OUTER JOIN " + BongsaggunContracts.ImageEntry.TABLE_NAME +
                        " ON " + BongsaggunContracts.ImageEntry.TABLE_NAME + "." + BongsaggunContracts.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID +
                        " = " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ID
        );
    }

    //query문 작성(where절, 앞에 부분)

    //image update할 때 사용
    //voluntary.voluntary_mainImageId = ?
    private static final String imageSelection =
            BongsaggunContracts.VoluntaryEntry.TABLE_NAME + "." + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ID + "= ?";

    //HomeList에서 사용
    private static final String sVoluntaryWithRegionSelection =
            BongsaggunContracts.RegionEntry.TABLE_NAME + "." + BongsaggunContracts.RegionEntry.COLUMN_REGION_ID + "= ?";

    private Cursor getHomeList(Uri uri, String[] projection, String sortOrder) {

        return sVoluntarySettingQueryBuilder.query(mOpenHelper.getReadableDatabase(),
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );
    }


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

    private void deleteDatabase() {
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
                return BongsaggunContracts.SchoolEntry.CONTENT_TYPE;
            case REGION:
                return BongsaggunContracts.RegionEntry.CONTENT_TYPE;
            case TIME:
                return BongsaggunContracts.TimeEntry.CONTENT_TYPE;
            case CATEGORY:
                return BongsaggunContracts.CategoryEntry.CONTENT_TYPE;
            case IMAGE:
                return BongsaggunContracts.ImageEntry.CONTENT_TYPE;
            case VOLUNTARY:
                return BongsaggunContracts.VoluntaryEntry.CONTENT_TYPE;
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
            case SCHOOL: {
                if (TextUtils.isEmpty(sortOrder)) {  //정렬값이 없다면 id를 기준으로 오름차순 정렬
                    sortOrder = BongsaggunContracts.SchoolEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = db.query(
                        BongsaggunContracts.SchoolEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            case REGION: {
                if (TextUtils.isEmpty(sortOrder)) {  //정렬값이 없다면 id를 기준으로 오름차순 정렬
                    sortOrder = BongsaggunContracts.RegionEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = db.query(
                        BongsaggunContracts.RegionEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            case TIME: {
                if (TextUtils.isEmpty(sortOrder)) {  //정렬값이 없다면 id를 기준으로 오름차순 정렬
                    sortOrder = BongsaggunContracts.TimeEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = db.query(
                        BongsaggunContracts.TimeEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            case CATEGORY: {
                if (TextUtils.isEmpty(sortOrder)) {  //정렬값이 없다면 id를 기준으로 오름차순 정렬
                    sortOrder = BongsaggunContracts.CategoryEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = db.query(
                        BongsaggunContracts.CategoryEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            case IMAGE: {
                retCursor = db.query(
                        BongsaggunContracts.ImageEntry.TABLE_NAME,  //테이블 이름
                        projection,                                //조회할 컬럼이름
                        selection,                                 //WHERE 절
                        selectionArgs,                             //WHERE 절 인자
                        null,                                      //GROUP BY 절
                        null,                                      //HAVING 절
                        sortOrder                                  //ORDER BY 절
                );
                break;
            }
            case VOLUNTARY: {
                if (TextUtils.isEmpty(sortOrder)) {  //정렬값이 없다면 id를 기준으로 내림차순 정렬
                    sortOrder = BongsaggunContracts.VoluntaryEntry.SORT_ORDER_DEFAULT;
                }
//                retCursor = db.query(
//                        BongsaggunContract.VoluntaryEntry.TABLE_NAME,  //테이블 이름
//                        projection,                                //조회할 컬럼이름
//                        selection,                                 //WHERE 절
//                        selectionArgs,                             //WHERE 절 인자
//                        null,                                      //GROUP BY 절
//                        null,                                      //HAVING 절
//                        sortOrder                                  //ORDER BY 절
//                );
                retCursor = getHomeList(uri, projection, sortOrder);

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
                long _id = db.insert(BongsaggunContracts.SchoolEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.SchoolEntry.buildSchoolUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case REGION: {
                long _id = db.insert(BongsaggunContracts.RegionEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.RegionEntry.buildRegionUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case TIME: {
                long _id = db.insert(BongsaggunContracts.TimeEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.TimeEntry.buildTimeUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case CATEGORY: {
                long _id = db.insert(BongsaggunContracts.CategoryEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.CategoryEntry.buildCategoryUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IMAGE: {
                long _id = db.insert(BongsaggunContracts.ImageEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.ImageEntry.buildImageUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case VOLUNTARY: {
                long _id = db.insert(BongsaggunContracts.VoluntaryEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = BongsaggunContracts.VoluntaryEntry.buildVoluntaryUri(_id);
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
                        BongsaggunContracts.SchoolEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case REGION:
                rowsDeleted = db.delete(
                        BongsaggunContracts.RegionEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case TIME:
                rowsDeleted = db.delete(
                        BongsaggunContracts.TimeEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case CATEGORY:
                rowsDeleted = db.delete(
                        BongsaggunContracts.CategoryEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case IMAGE:
                rowsDeleted = db.delete(
                        BongsaggunContracts.ImageEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsDeleted = db.delete(
                        BongsaggunContracts.VoluntaryEntry.TABLE_NAME, selection, selectionArgs);
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
                        BongsaggunContracts.SchoolEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case REGION:
                rowsUpdated = db.update(
                        BongsaggunContracts.RegionEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case TIME:
                rowsUpdated = db.update(
                        BongsaggunContracts.TimeEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case CATEGORY:
                rowsUpdated = db.update(
                        BongsaggunContracts.CategoryEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case IMAGE:
                rowsUpdated = db.update(
                        BongsaggunContracts.ImageEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsUpdated = db.update(
                        BongsaggunContracts.VoluntaryEntry.TABLE_NAME, values, selection, selectionArgs);
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
        final String authority = BongsaggunContracts.CONTENT_AUTHORITY;

        matcher.addURI(authority, BongsaggunContracts.PATH_SCHOOL, SCHOOL);
//        matcher.addURI(authority, VoluntaryContract.PATH_SCHOOL, + "/*", );

        matcher.addURI(authority, BongsaggunContracts.PATH_REGION, REGION);
        matcher.addURI(authority, BongsaggunContracts.PATH_TIME, TIME);
        matcher.addURI(authority, BongsaggunContracts.PATH_CATEGORY, CATEGORY);
        matcher.addURI(authority, BongsaggunContracts.PATH_IMAGE, IMAGE);
        matcher.addURI(authority, BongsaggunContracts.PATH_VOLUNTARY, VOLUNTARY);

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
                        long _id = db.insert(BongsaggunContracts.SchoolEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(BongsaggunContracts.RegionEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(BongsaggunContracts.ImageEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            case TIME:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContracts.TimeEntry.TABLE_NAME, null, value);
                        if (_id != -1) {
                            returnCount++;
                        }
                    }
                    db.setTransactionSuccessful();
                } finally {
                    db.endTransaction();
                }
                break;
            case CATEGORY:
                db.beginTransaction();
                try {
                    for (ContentValues value : values) {
                        long _id = db.insert(BongsaggunContracts.CategoryEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(BongsaggunContracts.VoluntaryEntry.TABLE_NAME, null, value);
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
