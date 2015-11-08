package io.j2ffrey_2.bongsaggun.homelist;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;

import io.j2ffrey_2.bongsaggun.VoluntaryContract;

public class JsonParser {

    public static final String TAG = JsonParser.class.getSimpleName();

    public static void jsonVoluntaryListParser(String strJson) throws JSONException {

        JSONObject jsonObject = new JSONObject(strJson);
        Log.d(TAG, "jsonObject " + jsonObject);

        JSONArray jsonArray = jsonObject.getJSONArray("Bongsa");
        Log.d(TAG, "jsonObject " + -100);

        String[] jsonName = {"id", "is_approval", "address", "img_main", "img_poster", "name",
                "content", "is_edu", "status", "organization_id", "clerk_name", "clerk_call", "clerk_email", "is_regular",
                "date_recruit_start", "date_recruit_end", "date_real_start", "date_real_end", "time_daily_start", "time_daily_end",
                "time_expect_total", "vltr_num", "vltr_age_id", "vltr_sex", "vltr_req", "region_id", "school_id", "btime_id",
                "category_id", "admin_add", "admin_mod", "act_time", "created_at", "updated_at"};

        for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
            JSONObject json = jsonArray.getJSONObject(i);

            Integer id = json.getInt(jsonName[j++]);
            Boolean isApproval = json.optBoolean(jsonName[j++], false);
            String address = json.optString(jsonName[j++], "");
            JSONObject joMainImage = json.getJSONObject(jsonName[j++]);
            String urlMainImage = joMainImage.optString("url", "");
            JSONObject joPosterImage = json.getJSONObject(jsonName[j++]);
            String urlPosterImage = joPosterImage.optString("url", "");
            String name = json.optString(jsonName[j++], "");
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

            Log.d(TAG, "parseredData " + id + " " + isApproval + " " + address + " " + urlMainImage + " " + urlPosterImage + " " + name + " " + content + " " + isEdu + " " + status + " " + origanizationId
                    + " " + clerkName + " " + clerkCall + " " + clerkEmail + " " + isRegular + " " + dateRecruitStart + " " + dateRecruitEnd + " " + dateRealStart + " " + dateRealEnd + " " + timeDailyStart
                    + " " + timeDailyEnd + " " + timeExpectTotal + " " + vltrNum + " " + vltrAgeId + " " + vltrSex + " " + vltrReq + " " + regionId + " " + schoolId + " " + bTimeId + " " + categoryId
                    + " " + adminAdd + " " + admin_mod + " " + actTime + " " + createdAt + " " + updatedAt);
            //파싱 끝 어딘가에 저장하기
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
                Log.d(TAG, "parseredData " + id + " " + name + " " + createdAt + " " + updatedAt);

                ContentValues schoolValues = new ContentValues();
                schoolValues.put(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_ID, id);
                schoolValues.put(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_NAME, name);
                schoolValues.put(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_CREATEAT, createdAt);
                schoolValues.put(VoluntaryContract.SchoolEntry.COLUMN_SCHOOL_UPDATEAT, updatedAt);

                cVVector.add(schoolValues);
            }

            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void jsonRegionListParser(String strJson) throws JSONException {

        JSONObject jsonObject = new JSONObject(strJson);
        Log.d(TAG, "jsonObject " + jsonObject);

        JSONArray jsonArray = jsonObject.getJSONArray("Region");

        String[] jsonName = {"id", "name", "created_at", "updated_at"};

        for (int i = 0, j = 0; i < jsonArray.length(); i++, j = 0) {
            JSONObject json = jsonArray.getJSONObject(i);

            Integer id = json.getInt(jsonName[j++]);
            String name = json.getString(jsonName[j++]);
            String createdAt = json.getString(jsonName[j++]);
            String updatedAt = json.getString(jsonName[j++]);

            Log.d(TAG, "parseredData " + id + " " + name + " " + createdAt + " " + updatedAt);
            //파싱 끝 어딘가에 저장하기
        }
    }
}
