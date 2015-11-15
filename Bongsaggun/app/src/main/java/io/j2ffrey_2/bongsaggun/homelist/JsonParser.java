package io.j2ffrey_2.bongsaggun.homelist;

import android.content.ContentValues;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import io.j2ffrey_2.bongsaggun.BongsaggunContract;

public class JsonParser {

    public static final String TAG = JsonParser.class.getSimpleName();

    public static Vector<ContentValues> jsonVoluntaryListParser(String strJson) {

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            Log.d(TAG, "jsonObject " + jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("Bongsa");
            Log.d(TAG, "jsonObject " + -100);

            String[] jsonName = {"id", "is_approval", "address", "img_main", "img_poster", "name",
                    "content", "is_edu", "status", "organization_id", "clerk_name", "clerk_call", "clerk_email", "is_regular",
                    "date_recruit_start", "date_recruit_end", "date_real_start", "date_real_end", "time_daily_start", "time_daily_end",
                    "time_expect_total", "vltr_num", "vltr_age_id", "vltr_sex", "vltr_req", "region_id", "school_id", "btime_id",
                    "category_id", "admin_add", "admin_mod", "act_time", "created_at", "updated_at"};

            Vector<ContentValues> cVVector = new Vector<>(jsonArray.length());

            for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
                JSONObject json = jsonArray.getJSONObject(i);

                Integer id = json.getInt(jsonName[j++]);
                Boolean approval = json.optBoolean(jsonName[j++], false);
                String address = json.optString(jsonName[j++], "");
                JSONObject joMainImage = json.getJSONObject(jsonName[j++]);
                String urlMainImage = joMainImage.optString("url", "");
                JSONObject joPosterImage = json.getJSONObject(jsonName[j++]);
                String urlPosterImage = joPosterImage.optString("url", "");
                String title = json.optString(jsonName[j++], "");
                String content = json.optString(jsonName[j++], "");
                Boolean isEdu = json.optBoolean(jsonName[j++], false);
                Integer status = json.optInt(jsonName[j++], -1);
                Integer origanizationId = json.optInt(jsonName[j++], -1);
                String clerkName = json.optString(jsonName[j++], "");
                String clerkCall = json.optString(jsonName[j++], "");
                String clerkEmail = json.optString(jsonName[j++], "");
                Boolean isRegular = json.optBoolean(jsonName[j++], false);
                String dateRecruitStart = json.optString(jsonName[j++], "");
                String dateRecruitEnd = json.optString(jsonName[j++], "");
                String dateRealStart = json.optString(jsonName[j++], "");
                String dateRealEnd = json.optString(jsonName[j++], "");
                String timeDailyStart = json.optString(jsonName[j++], "");
                String timeDailyEnd = json.optString(jsonName[j++], "");
                Integer timeExpectTotal = json.optInt(jsonName[j++], -1);
                Integer vltrNum = json.optInt(jsonName[j++], -1);
                Integer vltrAgeId = json.optInt(jsonName[j++], -1);
                Integer vltrSex = json.optInt(jsonName[j++], -1);
                String vltrReq = json.optString(jsonName[j++], "");
                Integer regionId = json.optInt(jsonName[j++], -1);
                Integer schoolId = json.optInt(jsonName[j++], -1);
                Integer bTimeId = json.optInt(jsonName[j++], -1);
                Integer categoryId = json.optInt(jsonName[j++], -1);
                String adminAdd = json.optString(jsonName[j++], "");
                String admin_mod = json.optString(jsonName[j++], "");
                Integer actTime = json.optInt(jsonName[j++], -1);
                String createdAt = json.getString(jsonName[j++]);
                String updatedAt = json.getString(jsonName[j++]);

                //파싱 끝 저장
//                Log.d(TAG, "parseredData " + id + " " + approval + " " + address + " " + urlMainImage + " " + urlPosterImage + " " + title + " " + content + " " + isEdu + " " + status + " " + origanizationId
//                        + " " + clerkName + " " + clerkCall + " " + clerkEmail + " " + isRegular + " " + dateRecruitStart + " " + dateRecruitEnd + " " + dateRealStart + " " + dateRealEnd + " " + timeDailyStart
//                        + " " + timeDailyEnd + " " + timeExpectTotal + " " + vltrNum + " " + vltrAgeId + " " + vltrSex + " " + vltrReq + " " + regionId + " " + schoolId + " " + bTimeId + " " + categoryId
//                        + " " + adminAdd + " " + admin_mod + " " + actTime + " " + createdAt + " " + updatedAt);

                ContentValues voluntaryValues = new ContentValues();
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_ID, id);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE, title);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT, content);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL, approval);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITSTART, dateRecruitStart);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATERECRUITEND, dateRecruitEnd);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATESTART, dateRealStart);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_DATEEND, dateRealEnd);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_IMAGEID, clerkEmail);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL, urlMainImage);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL, urlPosterImage);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME, clerkName);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL, clerkCall);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL, clerkEmail);
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID, regionId);
//                voluntaryValues.put(VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRE, );
//                voluntaryValues.put(VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIRESEX, );
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID, schoolId);
//                voluntaryValues.put(VoluntaryContract.VoluntaryEntry.COLUMN_VOLUNTARY_TIME, );
                voluntaryValues.put(BongsaggunContract.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT, updatedAt);

                cVVector.add(voluntaryValues);
            }

            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<ContentValues> jsonSchoolListParser(String strJson) {

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            Log.d(TAG, "jsonObject " + jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("School");

            String[] jsonName = {"id", "name", "created_at", "updated_at"};

            Vector<ContentValues> cVVector = new Vector<>(jsonArray.length());

            for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
                JSONObject json = jsonArray.getJSONObject(i);

                Integer id = json.getInt(jsonName[j++]);
                String name = json.getString(jsonName[j++]);
                String createdAt = json.getString(jsonName[j++]);
                String updatedAt = json.getString(jsonName[j++]);

                //파싱 끝 저장
//                Log.d(TAG, "parseredData " + id + " " + name + " " + createdAt + " " + updatedAt);

                ContentValues schoolValues = new ContentValues();
                schoolValues.put(BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_ID, id);
                schoolValues.put(BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_NAME, name);
                schoolValues.put(BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_CREATEAT, createdAt);
                schoolValues.put(BongsaggunContract.SchoolEntry.COLUMN_SCHOOL_UPDATEAT, updatedAt);

                cVVector.add(schoolValues);
            }
            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<ContentValues> jsonRegionListParser(String strJson) {

        try {

            JSONObject jsonObject = new JSONObject(strJson);
            Log.d(TAG, "jsonObject " + jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("Region");

            String[] jsonName = {"id", "name", "created_at", "updated_at"};

            Vector<ContentValues> cVVector = new Vector<>(jsonArray.length());

            for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
                JSONObject json = jsonArray.getJSONObject(i);

                Integer id = json.getInt(jsonName[j++]);
                String name = json.getString(jsonName[j++]);
                String createdAt = json.getString(jsonName[j++]);
                String updatedAt = json.getString(jsonName[j++]);

                //파싱 끝 저장
//                Log.d(TAG, "parseredData " + id + " " + name + " " + createdAt + " " + updatedAt);

                ContentValues regionValues = new ContentValues();
                regionValues.put(BongsaggunContract.RegionEntry.COLUMN_REGION_ID, id);
                regionValues.put(BongsaggunContract.RegionEntry.COLUMN_REGION_NAME, name);
                regionValues.put(BongsaggunContract.RegionEntry.COLUMN_REGION_CREATEAT, createdAt);
                regionValues.put(BongsaggunContract.RegionEntry.COLUMN_REGION_UPDATEAT, updatedAt);

                cVVector.add(regionValues);
            }
            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<ContentValues> jsonTimeListParser(String strJson) {

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            Log.d(TAG, "jsonObject " + jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("Btime");

            String[] jsonName = {"id", "name", "min", "max", "created_at", "updated_at"};

            Vector<ContentValues> cVVector = new Vector<>(jsonArray.length());

            for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
                JSONObject json = jsonArray.getJSONObject(i);

                Integer id = json.getInt(jsonName[j++]);
                String name = json.getString(jsonName[j++]);
                Integer min = json.getInt(jsonName[j++]);
                Integer max = json.getInt(jsonName[j++]);
                String createdAt = json.getString(jsonName[j++]);
                String updatedAt = json.getString(jsonName[j++]);

                //파싱 끝 저장
//                Log.d(TAG, "parseredData " + id + " " + name + " " + min + " " + max + " " + createdAt + " " + updatedAt);

                ContentValues timeValues = new ContentValues();
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_ID, id);
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_NAME, name);
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_MIN, min);
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_MAX, max);
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_CREATEAT, createdAt);
                timeValues.put(BongsaggunContract.TimeEntry.COLUMN_TIME_UPDATEAT, updatedAt);

                cVVector.add(timeValues);
            }
            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
