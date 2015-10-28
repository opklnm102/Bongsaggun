package io.j2ffrey_2.bongsaggun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by han on 2015-10-28.
 */
public class VoluntaryDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "voluntary.db";

    public VoluntaryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_SCHOOL_TABLE = "CREATE TABLE " + VoluntaryContract.SchoolEntry.TABLE_NAME + " (" +
                VoluntaryContract.SchoolEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_ID + " INTEGER NOT NULL, " +
                VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_NAME + " TEXT NOT NULL " +
                " FOREIGN KEY (" + VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_ID + ") REFERENCES " +
                VoluntaryContract.VoluntaryEntry.TABLE_NAME + " (" + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + ")" +
                " );";

        final String SQL_CREATE_REGION_TABLE = "CREATE TABLE " + VoluntaryContract.RegionEntry.TABLE_NAME + " (" +
                VoluntaryContract.RegionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VoluntaryContract.RegionEntry.COLUMN_REGION_ID + " INTEGER NOT NULL, " +
                VoluntaryContract.RegionEntry.COLUMN_REGION_NAME + " TEXT NOT NULL " +
                " FOREIGN KEY (" + VoluntaryContract.RegionEntry.COLUMN_REGION_ID + ") REFERENCES " +
                VoluntaryContract.VoluntaryEntry.TABLE_NAME + " (" + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + ")" +
                " );";

        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + VoluntaryContract.ImageEntry.TABLE_NAME + " (" +
                VoluntaryContract.ImageEntry._ID + " INTEGER PRIMARY KEY AUTONINCREMENT, " +
                VoluntaryContract.ImageEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL, " +
                VoluntaryContract.ImageEntry.COLUMN_IMAGE_MAINBLOB + " BLOB NOT NULL, " +
                VoluntaryContract.ImageEntry.COLUMN_IMAGE_POSTERBLOB + " BLOB NOT NULL, " +
                " FOREIGN KEY (" + VoluntaryContract.ImageEntry.COLUMN_IMAGE_ID + ") REFERENCES " +
                VoluntaryContract.VoluntaryEntry.TABLE_NAME + " (" + VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID + ")" +
                " );";

        //봉사정보
        final String SQL_CREATE_VOLUNTARY_TABLE = "CREATE TABLE " + VoluntaryContract.VoluntaryEntry.TABLE_NAME + " (" +
                VoluntaryContract.VoluntaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE + " TEXT NOT NULL, " +  //봉사제목
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT + " TEXT NOT NULL, " +  //상세내용
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITSTART + "TEXT NOT NULL, " +  //모집기간 시작
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITEND + "TEXT NOT NULL, " +  //모집기간 끝
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATESTART + "TEXT NOT NULL, " +  //봉사기간 시작
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATEEND + "TEXT NOT NULL, " +  //봉사기간 끝
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME + " TEXT NOT NULL, " +  //봉사시간
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID + "INTEGER NOT NULL, " +  //이미지 id
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL + "TEXT NOT NULL, " +  //메인 이미지 url
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL + "TEXT NOT NULL, " +  //포스터 이미지 url
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_PHONE + "TEXT NOT NULL, " +  //담당자 연락처
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRE + "TEXT NOT NULL, " +  //지원가능 조건
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRESEX + "TEXT NOT NULL, " +  //지원가능 성별
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + "TEXT NOT NULL, " +  //활동지역 id
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + "TEXT NOT NULL, " +  //학교 id
                VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT + "TEXT NOT NULL, " +  //DB업데이트 판별
                " );";

        db.execSQL(SQL_CREATE_IMAGE_TABLE);
        db.execSQL(SQL_CREATE_REGION_TABLE);
        db.execSQL(SQL_CREATE_SCHOOL_TABLE);
        db.execSQL(SQL_CREATE_VOLUNTARY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + VoluntaryContract.ImageEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VoluntaryContract.RegionEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VoluntaryContract.SchoolEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + VoluntaryContract.VoluntaryEntry.TABLE_NAME);
        onCreate(db);
    }
}
