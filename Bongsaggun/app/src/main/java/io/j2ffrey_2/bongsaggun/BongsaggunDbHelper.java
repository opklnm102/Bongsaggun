package io.j2ffrey_2.bongsaggun;

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

        final String SQL_CREATE_SCHOOL_TABLE = "CREATE TABLE " + BongsaggunContract.SchoolEntry.TABLE_NAME + " (" +
                BongsaggunContract.SchoolEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_NAME + " TEXT NOT NULL, " +
                BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_UPDATEAT + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_REGION_TABLE = "CREATE TABLE " + BongsaggunContract.RegionEntry.TABLE_NAME + " (" +
                BongsaggunContract.RegionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContract.RegionEntry.COLUMN_REGION_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.RegionEntry.COLUMN_REGION_NAME + " TEXT NOT NULL, " +
                BongsaggunContract.RegionEntry.COLUMN_REGION_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContract.RegionEntry.COLUMN_REGION_UPDATEAT + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_TIME_TABLE = "CREATE TABLE " + BongsaggunContract.TimeEntry.TABLE_NAME + " (" +
                BongsaggunContract.TimeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BongsaggunContract.TimeEntry.COLUMN_TIME_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.TimeEntry.COLUMN_TIME_NAME + " TEXT NOT NULL," +
                BongsaggunContract.TimeEntry.COLUMN_TIME_MIN + " INTEGER NOT NULL," +
                BongsaggunContract.TimeEntry.COLUMN_TIME_MAX + " INTEGER NOT NULL," +
                BongsaggunContract.TimeEntry.COLUMN_TIME_CREATEAT + " TEXT NOT NULL," +
                BongsaggunContract.TimeEntry.COLUMN_TIME_UPDATEAT + " TEXT NOT NULL" +
                " );";

        final String SQL_CREATE_CATEGORY_TABLE = "CREATE TABLE " + BongsaggunContract.CategoryEntry.TABLE_NAME + " (" +
                BongsaggunContract.CategoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContract.CategoryEntry.COLUMN_CATEGORY_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.CategoryEntry.COLUMN_CATEGORY_NAME + " TEXT NOT NULL, " +
                BongsaggunContract.CategoryEntry.COLUMN_CATEGORY_CREATEAT + " TEXT NOT NULL, " +
                BongsaggunContract.CategoryEntry.COLUMN_CATEGORY_UPDATEAT + " TEXT NOT NULL " +
                " );";

        //봉사정보
        final String SQL_CREATE_VOLUNTARY_TABLE = "CREATE TABLE " + BongsaggunContract.VoluntaryEntry.TABLE_NAME + " (" +
                BongsaggunContract.VoluntaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE + " TEXT NOT NULL, " +  //봉사제목
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SUMMARY + " TEXT, " +  //요약
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT + " TEXT, " +  //상세내용
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENTETC + " TEXT, " +  //기타내용
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS + " TEXT, " +  //장소
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL + " TEXT NOT NULL, " +  //인증서 발급여부
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_LINK + " TEXT, " +  //링크
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START + " TEXT NOT NULL, " +  //모집기간 시작
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END + " TEXT NOT NULL, " +  //모집기간 끝
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_START + " TEXT NOT NULL, " +  //봉사기간 시작
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_END + " TEXT NOT NULL, " +  //봉사기간 끝
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME + " TEXT, " +  //봉사시간
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL + " TEXT, " +  //메인 이미지 url
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL + " TEXT, " +  //포스터 이미지 url
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_INCENTIVE + " TEXT, " +  //활동혜택
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIREMENT + " TEXT, " +  //지원가능 조건
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL + " INTEGER, " +  //지원가능 조건
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT + " INTEGER, " +  //지원가능 조건
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_STATUS + " TEXT, " +  //현재상태
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME + " TEXT, " +  //담당자 이름
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL + " TEXT, " +  //담당자 전화
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL + " TEXT, " +  //담당자 이메일
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKLINK + " TEXT, " +  //담당자 링크
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ORIGANIZATIONID + " INTEGER, " +  //기관 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + " INTEGER NOT NULL, " +  //활동지역 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + " INTEGER NOT NULL, " +  //학교 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID + " INTEGER NOT NULL, " +  //카테고리 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID + " INTEGER NOT NULL, " +  //봉사시간 id

                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START_YEAR + " INTEGER, " +  //모집기간 시작 년
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START_MONTH + " INTEGER, " +  //모집기간 시작 월
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START_DAY + " INTEGER, " +  //모집기간 시작 일
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START_DAYOFWEEK + " TEXT, " +  //모집기간 시작 요일

                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END_YEAR + " INTEGER, " +  //모집기간 끝 년
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END_MONTH + " INTEGER, " +  //모집기간 끝 월
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END_DAY + " INTEGER, " +  //모집기간 끝 일
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END_DAYOFWEEK + " TEXT, " +  //모집기간 끝 요일

                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT + " TEXT NOT NULL, " +  //DB업데이트 판별
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID + ") REFERENCES " +
                BongsaggunContract.CategoryEntry.TABLE_NAME + " (" + BongsaggunContract.CategoryEntry.COLUMN_CATEGORY_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID + ") REFERENCES " +
                BongsaggunContract.TimeEntry.TABLE_NAME + " (" + BongsaggunContract.TimeEntry.COLUMN_TIME_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + ") REFERENCES " +
                BongsaggunContract.SchoolEntry.TABLE_NAME + " (" + BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + ") REFERENCES " +
                BongsaggunContract.RegionEntry.TABLE_NAME + " (" + BongsaggunContract.RegionEntry.COLUMN_REGION_ID + ")" +
                " );";

        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + BongsaggunContract.ImageEntry.TABLE_NAME + " (" +
                BongsaggunContract.ImageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_MAINBLOB + " BLOB," +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_POSTERBLOB + " BLOB, " +
                " FOREIGN KEY (" + BongsaggunContract.ImageEntry.COLUMN_IMAGE_FK_VOLUNTARY_ID + ") REFERENCES " +
                BongsaggunContract.VoluntaryEntry.TABLE_NAME + " (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + ")" +
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

            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.ImageEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.VoluntaryEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.CategoryEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.RegionEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.SchoolEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.TimeEntry.TABLE_NAME);

            onCreate(db);
            version = CUR_DATABASE_VERSION;
        }
    }

    public static void deleteDatabase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}
