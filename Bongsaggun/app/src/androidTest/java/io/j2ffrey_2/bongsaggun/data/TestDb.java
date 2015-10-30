package io.j2ffrey_2.bongsaggun.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import java.util.HashSet;

import io.j2ffrey_2.bongsaggun.VoluntaryContract;
import io.j2ffrey_2.bongsaggun.VoluntaryDbHelper;

/**
 * Created by han on 2015-10-29.
 */
public class TestDb extends AndroidTestCase{

    public static final String LOG_TAG = TestDb.class.getSimpleName();

    void deleteTheDatabase(){
        mContext.deleteDatabase(VoluntaryDbHelper.DATABASE_NAME);
    }

    public void setUp(){
        deleteTheDatabase();
    }

    public void testCreateDb() throws Throwable {

        final HashSet<String> tableNameHashSet = new HashSet<>();
        tableNameHashSet.add(VoluntaryContract.SchoolEntry.TABLE_NAME);
        tableNameHashSet.add(VoluntaryContract.RegionEntry.TABLE_NAME);
        tableNameHashSet.add(VoluntaryContract.ImageEntry.TABLE_NAME);
        tableNameHashSet.add(VoluntaryContract.VoluntaryEntry.TABLE_NAME);

        mContext.deleteDatabase(VoluntaryDbHelper.DATABASE_NAME);
        SQLiteDatabase db = new VoluntaryDbHelper(this.mContext).getWritableDatabase();
        assertEquals(true, db.isOpen());

        Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);

        assertTrue("Error: This means that the database as not been created correctly", cursor.moveToFirst());

        do{
            tableNameHashSet.remove(cursor.getString(0));
        }while (cursor.moveToNext());

        assertTrue("Error: Your database was created without both the location entry and weather entry tables", tableNameHashSet.isEmpty());

        cursor = db.rawQuery("PRAGMA table_info(" + VoluntaryContract.SchoolEntry.TABLE_NAME + ")", null);

        assertTrue("Error: This means that we were unable to query the database for table information.", cursor.moveToFirst());

        final HashSet<String> schoolColumnHashSet = new HashSet<>();
        schoolColumnHashSet.add(VoluntaryContract.SchoolEntry._ID);
        schoolColumnHashSet.add(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_ID);
        schoolColumnHashSet.add(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_NAME);

        int columnNameIndex = cursor.getColumnIndex("name");
        do{
            String columnName = cursor.getString(columnNameIndex);
            schoolColumnHashSet.remove(columnName);
        }while (cursor.moveToNext());

        assertTrue("Error: The database doesn't contain all of the required school entry columns", schoolColumnHashSet.isEmpty());
        db.close();
    }

    public void testSchoolTable() {
        insertSchool();
    }









    public long insertSchool(){
        VoluntaryDbHelper dbHelper = new VoluntaryDbHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

//        ContentValues testValues = TestUtils

        return (long)23;
    }
}
