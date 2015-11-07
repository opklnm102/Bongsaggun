package io.j2ffrey_2.bongsaggun;

import android.annotation.TargetApi;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by han on 2015-10-29.
 */
public class VoluntaryProvider extends ContentProvider {

    public static final String TAG = VoluntaryProvider.class.getSimpleName();

    private static final UriMatcher sUriMatcher = buildUriMatcher();
    private VoluntaryDbHelper mOpenHelper;

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
        sVoluntarySettingQueryBuilder.setTables(VoluntaryContract.VoluntaryEntry.TABLE_NAME +
                        " LEFT OUTER JOIN " + VoluntaryContract.RegionEntry.TABLE_NAME +
                        "ON " + VoluntaryContract.RegionEntry.TABLE_NAME + "." + VoluntaryContract.RegionEntry.COLUMN_REGION_ID +
                        "=" + VoluntaryContract.VoluntaryEntry.TABLE_NAME + "." + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID +
                        " LEFT OUTER JOIN " + VoluntaryContract.SchoolEntry.TABLE_NAME +
                        "ON " + VoluntaryContract.SchoolEntry.TABLE_NAME + "." + VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_ID +
                        "=" + VoluntaryContract.VoluntaryEntry.TABLE_NAME + "." + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID +
                        " LEFT OUTER JOIN " + VoluntaryContract.ImageEntry.TABLE_NAME +
                        "ON " + VoluntaryContract.ImageEntry.TABLE_NAME + "." + VoluntaryContract.ImageEntry.COLUMN_IMAGE_ID +
                        "=" + VoluntaryContract.VoluntaryEntry.TABLE_NAME + "." + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID
        );
    }

    //query문 작성(where절, 앞에 부분)

    //image update할 때 사용
    //voluntary.voluntary_mainImageId = ?
    private static final String imageSelection =
            VoluntaryContract.VoluntaryEntry.TABLE_NAME + "." + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID + "= ?";

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
        mOpenHelper = new VoluntaryDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {

        final int match = sUriMatcher.match(uri);

        switch (match) {
            case SCHOOL:
                return VoluntaryContract.SchoolEntry.CONTENT_TYPE;
            case REGION:
                return VoluntaryContract.RegionEntry.CONTENT_TYPE;
            case IMAGE:
                return VoluntaryContract.ImageEntry.CONTENT_TYPE;
            case VOLUNTARY:
                return VoluntaryContract.VoluntaryEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

        Cursor retCursor;

        //uri객체를 통해 원하는 요청이 무엇인지 검사
        switch (sUriMatcher.match(uri)) {
            // "school"
            case SCHOOL: {
                if(TextUtils.isEmpty(sortOrder)){  //정렬값이 없다면 id를 기준으로 정렬
                    sortOrder = VoluntaryContract.SchoolEntry.SORT_ORDER_DEFAULT;
                }
                retCursor = mOpenHelper.getReadableDatabase().query(
                        VoluntaryContract.SchoolEntry.TABLE_NAME,  //테이블 이름
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
                retCursor = mOpenHelper.getReadableDatabase().query(
                        VoluntaryContract.RegionEntry.TABLE_NAME,  //테이블 이름
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
                retCursor = mOpenHelper.getReadableDatabase().query(
                        VoluntaryContract.ImageEntry.TABLE_NAME,  //테이블 이름
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
                retCursor = mOpenHelper.getReadableDatabase().query(
                        VoluntaryContract.VoluntaryEntry.TABLE_NAME,  //테이블 이름
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
                long _id = db.insert(VoluntaryContract.SchoolEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = VoluntaryContract.SchoolEntry.buildSchoolUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case REGION: {
                long _id = db.insert(VoluntaryContract.RegionEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = VoluntaryContract.RegionEntry.buildRegionUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IMAGE: {
                long _id = db.insert(VoluntaryContract.ImageEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = VoluntaryContract.ImageEntry.buildImageUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case VOLUNTARY: {
                long _id = db.insert(VoluntaryContract.VoluntaryEntry.TABLE_NAME, null, values);
                if (_id > 0)
                    returnUri = VoluntaryContract.VoluntaryEntry.buildVoluntaryUri(_id);
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
                        VoluntaryContract.SchoolEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case REGION:
                rowsDeleted = db.delete(
                        VoluntaryContract.RegionEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case IMAGE:
                rowsDeleted = db.delete(
                        VoluntaryContract.ImageEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsDeleted = db.delete(
                        VoluntaryContract.VoluntaryEntry.TABLE_NAME, selection, selectionArgs);
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
                        VoluntaryContract.SchoolEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case REGION:
                rowsUpdated = db.update(
                        VoluntaryContract.RegionEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case IMAGE:
                rowsUpdated = db.update(
                        VoluntaryContract.ImageEntry.TABLE_NAME, values, selection, selectionArgs);
                break;
            case VOLUNTARY:
                rowsUpdated = db.update(
                        VoluntaryContract.VoluntaryEntry.TABLE_NAME, values, selection, selectionArgs);
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
        final String authority = VoluntaryContract.CONTENT_AUTHORITY;

        matcher.addURI(authority, VoluntaryContract.PATH_SCHOOL, SCHOOL);
//        matcher.addURI(authority, VoluntaryContract.PATH_SCHOOL, + "/*", );

        matcher.addURI(authority, VoluntaryContract.PATH_REGION, REGION);
        matcher.addURI(authority, VoluntaryContract.PATH_IMAGE, IMAGE);
        matcher.addURI(authority, VoluntaryContract.PATH_VOLUNTARY, VOLUNTARY);

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
                        long _id = db.insert(VoluntaryContract.SchoolEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(VoluntaryContract.RegionEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(VoluntaryContract.ImageEntry.TABLE_NAME, null, value);
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
                        long _id = db.insert(VoluntaryContract.VoluntaryEntry.TABLE_NAME, null, value);
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
