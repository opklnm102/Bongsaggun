package io.j2ffrey_2.bongsaggun;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by han on 2015-10-28.
 */
public class VoluntaryDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "voluntary.db";

    public VoluntaryDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//        Voluntary(이름바꿀것)   //봉사정보
//        INTEGER  id
//        TEXT  content  //상세내용
//        TEXT  dateRecruitStart   //모집기간
//        TEXT  dateRecruitEnd   //모집기간
//        TEXT  dateStart   //봉사기간
//        TEXT  dateEnd   //봉사기간
//        INTEGER mainImageId   //메인 이미지 id  -> 이미지 테이블이랑 relationship
//        TEXT  mainImageURL    //메인 이미지 url  -> 로딩용
//        INTEGER posterImageId   //포스터 이미지 id -> 이미지 테이블이랑 relationship
//        TEXT  posterImageURL   //포스터 이미지 url  -> 로딩용
//        TEXT  phone   //담당자 연락처
//        INTEGER  regioinId   //활동지역 id
//        TEXT  require   //지원가능 조건
//        TEXT  requireSex   //지원가능 성별
//        INTEGER  schoolId   //학교 id (검색시 사용)
//        TEXT  time   //봉사시간
//        TEXT  title   //봉사제목
//        TEXT  updateAt   //DB 업데이트 판별

        // Create a table to hold locations.  A location consists of the string supplied in the
        // location setting, the city name, and the latitude and longitude
//        final String SQL_CREATE_LOCATION_TABLE = "CREATE TABLE " + LocationEntry.TABLE_NAME + " (" +
//                LocationEntry._ID + " INTEGER PRIMARY KEY," +
//                LocationEntry.COLUMN_LOCATION_SETTING + " TEXT UNIQUE NOT NULL, " +
//                LocationEntry.COLUMN_CITY_NAME + " TEXT NOT NULL, " +
//                LocationEntry.COLUMN_COORD_LAT + " REAL NOT NULL, " +
//                LocationEntry.COLUMN_COORD_LONG + " REAL NOT NULL " +
//                " );";
//
//        final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE " + WeatherEntry.TABLE_NAME + " (" +
//                // Why AutoIncrement here, and not above?
//                // Unique keys will be auto-generated in either case.  But for weather
//                // forecasting, it's reasonable to assume the user will want information
//                // for a certain date and all dates *following*, so the forecast data
//                // should be sorted accordingly.
//                WeatherEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
//
//                // the ID of the location entry associated with this weather data
//                WeatherEntry.COLUMN_LOC_KEY + " INTEGER NOT NULL, " +
//                WeatherEntry.COLUMN_DATE + " INTEGER NOT NULL, " +
//                WeatherEntry.COLUMN_SHORT_DESC + " TEXT NOT NULL, " +
//                WeatherEntry.COLUMN_WEATHER_ID + " INTEGER NOT NULL," +
//
//                WeatherEntry.COLUMN_MIN_TEMP + " REAL NOT NULL, " +
//                WeatherEntry.COLUMN_MAX_TEMP + " REAL NOT NULL, " +
//
//                WeatherEntry.COLUMN_HUMIDITY + " REAL NOT NULL, " +
//                WeatherEntry.COLUMN_PRESSURE + " REAL NOT NULL, " +
//                WeatherEntry.COLUMN_WIND_SPEED + " REAL NOT NULL, " +
//                WeatherEntry.COLUMN_DEGREES + " REAL NOT NULL, " +
//
//                // Set up the location column as a foreign key to location table.
//                " FOREIGN KEY (" + WeatherEntry.COLUMN_LOC_KEY + ") REFERENCES " +
//                LocationEntry.TABLE_NAME + " (" + LocationEntry._ID + "), " +
//
//                // To assure the application have just one weather entry per day
//                // per location, it's created a UNIQUE constraint with REPLACE strategy
//                " UNIQUE (" + WeatherEntry.COLUMN_DATE + ", " +
//                WeatherEntry.COLUMN_LOC_KEY + ") ON CONFLICT REPLACE);";
//
//        sqLiteDatabase.execSQL(SQL_CREATE_LOCATION_TABLE);
//        sqLiteDatabase.execSQL(SQL_CREATE_WEATHER_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
