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

        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + BongsaggunContract.ImageEntry.TABLE_NAME + " (" +
                BongsaggunContract.ImageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_MAINBLOB + " BLOB," +
                BongsaggunContract.ImageEntry.COLUMN_IMAGE_POSTERBLOB + " BLOB" +
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

        //봉사정보
        final String SQL_CREATE_VOLUNTARY_TABLE = "CREATE TABLE " + BongsaggunContract.VoluntaryEntry.TABLE_NAME + " (" +
                BongsaggunContract.VoluntaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID + " INTEGER NOT NULL, " +
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE + " TEXT NOT NULL, " +  //봉사제목
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT + " TEXT, " +  //상세내용
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS + " TEXT, " +  //장소
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL + " TEXT NOT NULL, " +  //인증서 발급여부
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITSTART + " TEXT NOT NULL, " +  //모집기간 시작
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITEND + " TEXT NOT NULL, " +  //모집기간 끝
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATESTART + " TEXT NOT NULL, " +  //봉사기간 시작
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATEEND + " TEXT NOT NULL, " +  //봉사기간 끝
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME + " TEXT, " +  //봉사시간
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID + " INTEGER NOT NULL, " +  //이미지 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL + " TEXT, " +  //메인 이미지 url
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL + " TEXT, " +  //포스터 이미지 url
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME + " TEXT, " +  //담당자 이름
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL + " TEXT, " +  //담당자 전화
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL + " TEXT, " +  //담당자 이메일
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRE + " TEXT, " +  //지원가능 조건
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRESEX + " TEXT, " +  //지원가능 성별
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + " INTEGER NOT NULL, " +  //활동지역 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + " INTEGER NOT NULL, " +  //학교 id
                BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT + " TEXT NOT NULL, " +  //DB업데이트 판별
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID + ") REFERENCES " +
                BongsaggunContract.SchoolEntry.TABLE_NAME + " (" + BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID + ") REFERENCES " +
                BongsaggunContract.RegionEntry.TABLE_NAME + " (" + BongsaggunContract.RegionEntry.COLUMN_REGION_ID + ")," +
                " FOREIGN KEY (" + BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID + ") REFERENCES " +
                BongsaggunContract.ImageEntry.TABLE_NAME + " (" + BongsaggunContract.ImageEntry.COLUMN_IMAGE_ID + ")" +
                " );";

        db.execSQL(SQL_CREATE_IMAGE_TABLE);
        db.execSQL(SQL_CREATE_REGION_TABLE);
        db.execSQL(SQL_CREATE_SCHOOL_TABLE);
        db.execSQL(SQL_CREATE_TIME_TABLE);
        db.execSQL(SQL_CREATE_VOLUNTARY_TABLE);
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
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.RegionEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.SchoolEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.TimeEntry.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + BongsaggunContract.VoluntaryEntry.TABLE_NAME);

            onCreate(db);
            version = CUR_DATABASE_VERSION;
        }
    }

    public static void deleteDatabase(Context context){
        context.deleteDatabase(DATABASE_NAME);
    }
}
