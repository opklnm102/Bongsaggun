package io.j2ffrey_2.bongsaggun.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by han on 2015-10-28.
 */
public class BongsaggunDbHelper extends SQLiteOpenHelper {

    public static String TAG = BongsaggunDbHelper.class.getSimpleName();

    private static final int VER_RELEASE_A = 0x01;  //app version 1.0.0

    private static final int CUR_DATABASE_VERSION = VER_RELEASE_A;

    private static final String DATABASE_NAME = "bongsaggun.db";

    public BongsaggunDbHelper(Context context) {
        super(context, DATABASE_NAME, null, CUR_DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        final String SQL_CREATE_SCHOOL_TABLE = "CREATE TABLE " + BongsaggunContracts.SchoolEntry.TABLE_NAME + " (" +
                BongsaggunContracts.SchoolEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_NAME + " TEXT NOT NULL, " +
                BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_UPDATEAT + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_REGION_TABLE = "CREATE TABLE " + BongsaggunContracts.RegionEntry.TABLE_NAME + " (" +
                BongsaggunContracts.RegionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContracts.RegionEntry.COLUMN_REGION_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.RegionEntry.COLUMN_REGION_NAME + " TEXT NOT NULL, " +
                BongsaggunContracts.RegionEntry.COLUMN_REGION_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContracts.RegionEntry.COLUMN_REGION_UPDATEAT + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_TIME_TABLE = "CREATE TABLE " + BongsaggunContracts.TimeEntry.TABLE_NAME + " (" +
                BongsaggunContracts.TimeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_NAME + " TEXT NOT NULL," +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_MIN + " INTEGER NOT NULL," +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_MAX + " INTEGER NOT NULL," +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_CREATEAT + " TEXT NOT NULL," +
                BongsaggunContracts.TimeEntry.COLUMN_TIME_UPDATEAT + " TEXT NOT NULL" +
                " );";

        final String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " + BongsaggunContracts.CategoryEntry.TABLE_NAME + " (" +
                BongsaggunContracts.CategoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_NAME + " TEXT NOT NULL, " +
                BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_UPDATEAT + " TEXT NOT NULL " +
                " );";

        //봉사정보
        final String SQL_CREATE_VOLUNTARY_TABLE = "CREATE TABLE " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME + " (" +
                BongsaggunContracts.VoluntaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE + " TEXT NOT NULL, " +  //봉사제목
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SUMMARY + " TEXT, " +  //요약
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT + " TEXT, " +  //상세내용
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENTETC + " TEXT, " +  //기타내용
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS + " TEXT, " +  //장소
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL + " TEXT NOT NULL, " +  //인증서 발급여부
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_LINK + " TEXT, " +  //링크
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START + " TEXT NOT NULL, " +  //모집기간 시작
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END + " TEXT NOT NULL, " +  //모집기간 끝
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_START + " TEXT NOT NULL, " +  //봉사기간 시작
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_END + " TEXT NOT NULL, " +  //봉사기간 끝
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_TIME + " TEXT, " +  //봉사시간
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL + " TEXT, " +  //메인 이미지 url
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL + " TEXT, " +  //포스터 이미지 url
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_INCENTIVE + " TEXT, " +  //활동혜택
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIREMENT + " TEXT, " +  //지원가능 조건
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL + " INTEGER, " +  //지원가능 조건
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT + " INTEGER, " +  //지원가능 조건
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_STATUS + " TEXT, " +  //현재상태
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME + " TEXT, " +  //담당자 이름
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL + " TEXT, " +  //담당자 전화
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL + " TEXT, " +  //담당자 이메일
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKLINK + " TEXT, " +  //담당자 링크
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ORIGANIZATIONID + " INTEGER, " +  //기관 id
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + " INTEGER NOT NULL, " +  //활동지역 id
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + " INTEGER NOT NULL, " +  //학교 id
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID + " INTEGER NOT NULL, " +  //카테고리 id
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID + " INTEGER NOT NULL, " +  //봉사시간 id
                BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT + " TEXT NOT NULL, " +  //DB업데이트 판별
                " FOREIGN KEY (" + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID + ") REFERENCES " +
                BongsaggunContracts.CategoryEntry.TABLE_NAME + " (" + BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID + ") REFERENCES " +
                BongsaggunContracts.TimeEntry.TABLE_NAME + " (" + BongsaggunContracts.TimeEntry.COLUMN_TIME_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + ") REFERENCES " +
                BongsaggunContracts.SchoolEntry.TABLE_NAME + " (" + BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + ") REFERENCES " +
                BongsaggunContracts.RegionEntry.TABLE_NAME + " (" + BongsaggunContracts.RegionEntry.COLUMN_REGION_ID + ")" +
                " );";

        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + BongsaggunContracts.ImageEntry.TABLE_NAME + " (" +
                BongsaggunContracts.ImageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BongsaggunContracts.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                BongsaggunContracts.ImageEntry.COLUMN_IMAGE_MAINBLOB + " BLOB," +
                BongsaggunContracts.ImageEntry.COLUMN_IMAGE_POSTERBLOB + " BLOB, " +
                " FOREIGN KEY (" + BongsaggunContracts.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID + ") REFERENCES " +
                BongsaggunContracts.VoluntaryEntry.TABLE_NAME + " (" + BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ID + ")" +
                " );";

        db.execSQL(SQL_CREATE_REGION_TABLE);
        db.execSQL(SQL_CREATE_SCHOOL_TABLE);
        db.execSQL(SQL_CREATE_TIME_TABLE);
        db.execSQL(SQL_CREATE_CATEGORY_TABLE);
        db.execSQL(SQL_CREATE_VOLUNTARY_TABLE);
        db.execSQL(SQL_CREATE_IMAGE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i(TAG, "db open");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, " onUpgrade() from " + oldVersion + "to " + newVersion);

        int version = oldVersion;

        if(version != CUR_DATABASE_VERSION){
            Log.d(TAG, "Upgrade unsuccessful -- destroying old data during upgrade");

            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.ImageEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.VoluntaryEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.CategoryEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.RegionEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.SchoolEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContracts.TimeEntry.TABLE_NAME);

            onCreate(db);
            version = CUR_DATABASE_VERSION;
        }
    }

    public static void deleteDatabase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}
