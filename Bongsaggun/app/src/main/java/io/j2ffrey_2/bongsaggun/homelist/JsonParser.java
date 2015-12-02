package io.j2ffrey_2.bongsaggun.homelist;

import android.content.ContentValues;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Vector;

import io.j2ffrey_2.bongsaggun.BongsaggunContracts;

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

//                Integer id = json.getInt(jsonName[j++]);
//                Boolean approval = json.optBoolean(jsonName[j++], false);
//                String address = json.optString(jsonName[j++], "");
//                JSONObject joMainImage = json.getJSONObject(jsonName[j++]);
//                String urlMainImage = joMainImage.optString("url", "");
//                JSONObject joPosterImage = json.getJSONObject(jsonName[j++]);
//                String urlPosterImage = joPosterImage.optString("url", "");
//                String title = json.optString(jsonName[j++], "");
//                String content = json.optString(jsonName[j++], "");
//                Boolean isEdu = json.optBoolean(jsonName[j++], false);
//                Integer status = json.optInt(jsonName[j++], -1);
//                Integer origanizationId = json.optInt(jsonName[j++], -1);
//                String clerkName = json.optString(jsonName[j++], "");
//                String clerkCall = json.optString(jsonName[j++], "");
//                String clerkEmail = json.optString(jsonName[j++], "");
//                Boolean isRegular = json.optBoolean(jsonName[j++], false);
//                String dateRecruitStart = json.optString(jsonName[j++], "");
//                String dateRecruitEnd = json.optString(jsonName[j++], "");
//                String dateRealStart = json.optString(jsonName[j++], "");
//                String dateRealEnd = json.optString(jsonName[j++], "");
//                String timeDailyStart = json.optString(jsonName[j++], "");
//                String timeDailyEnd = json.optString(jsonName[j++], "");
//                Integer timeExpectTotal = json.optInt(jsonName[j++], -1);
//                Integer vltrNum = json.optInt(jsonName[j++], -1);
//                Integer vltrAgeId = json.optInt(jsonName[j++], -1);
//                Integer vltrSex = json.optInt(jsonName[j++], -1);
//                String vltrReq = json.optString(jsonName[j++], "");
//                Integer regionId = json.optInt(jsonName[j++], -1);
//                Integer schoolId = json.optInt(jsonName[j++], -1);
//                Integer bTimeId = json.optInt(jsonName[j++], -1);
//                Integer categoryId = json.optInt(jsonName[j++], -1);
//                String adminAdd = json.optString(jsonName[j++], "");
//                String admin_mod = json.optString(jsonName[j++], "");
//                Integer actTime = json.optInt(jsonName[j++], -1);
//                String createdAt = json.getString(jsonName[j++]);
//                String updatedAt = json.getString(jsonName[j++]);


                Integer id = json.getInt("id");
                Boolean approval = json.optBoolean("is_approval", false);
                String address = json.optString("address", "");
                JSONObject joMainImage = json.getJSONObject("img_main");
                String urlMainImage = joMainImage.optString("url", "");
                JSONObject joPosterImage = json.getJSONObject("img_poster");
                String urlPosterImage = joPosterImage.optString("url", "");
                String title = json.optString("name", "");
                String content = json.optString("content", "");
                String summary = json.optString("summary", "");
                String contentEtc = json.optString("content_etc", "");
                String incentive = json.optString("incentive", "");
                String status = json.optString("status", "");
                String link = json.optString("link", "");
                String dateRecruitStart = json.optString("date_recruit_start", "");
                String dateRecruitEnd = json.optString("date_recruit_end", "");
                String dateRealStart = json.optString("date_real_start", "");
                String dateRealEnd = json.optString("date_real_end", "");
                String clerkName = json.optString("clerk_name", "");
                String clerkCall = json.optString("clerk_call", "");
                String clerkEmail = json.optString("clerk_email", "");
                String clerkLink = json.optString("clerk_link", "");
                String vltrReq = json.optString("vltr_req", "");
                String recruitPeopleTotal = json.optString("vltr_num", "");
                String recruitPeopleCurrent = json.optString("vltr_num2", "");
                Integer origanizationId = json.optInt("organization_id", -1);
                Integer regionId = json.optInt("region_id", -1);
                Integer schoolId = json.optInt("school_id", -1);
                Integer bTimeId = json.optInt("btime_id", -1);
                Integer categoryId = json.optInt("category_id", -1);
                Integer timeExpectTotal = json.optInt("time_expect_total", -1);
                String updatedAt = json.getString("updated_at");


                //파싱 끝 저장
//                Log.d(TAG, "parseredData " + id + " " + approval + " " + address + " " + urlMainImage + " " + urlPosterImage + " " + title + " " + content + " " + isEdu + " " + status + " " + origanizationId
//                        + " " + clerkName + " " + clerkCall + " " + clerkEmail + " " + isRegular + " " + dateRecruitStart + " " + dateRecruitEnd + " " + dateRealStart + " " + dateRealEnd + " " + timeDailyStart
//                        + " " + timeDailyEnd + " " + timeExpectTotal + " " + vltrNum + " " + vltrAgeId + " " + vltrSex + " " + vltrReq + " " + regionId + " " + schoolId + " " + bTimeId + " " + categoryId
//                        + " " + adminAdd + " " + admin_mod + " " + actTime + " " + createdAt + " " + updatedAt);

                ContentValues voluntaryValues = new ContentValues();
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ID, id);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_TITLE, title);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ADDRESS, address);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SUMMARY, summary);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENT, content);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CONTENTETC, contentEtc);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_INCENTIVE, incentive);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_STATUS, status);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_LINK, link);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_APPROVAL, approval);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_START, dateRecruitStart);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_RECRUIT_END, dateRecruitEnd);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_START, dateRealStart);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_DATE_REAL_END, dateRealEnd);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_MAINIMAGEURL, urlMainImage);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_POSTERIMAGEURL, urlPosterImage);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKNAME, clerkName);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKCALL, clerkCall);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKEMAIL, clerkEmail);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CLERKLINK, clerkLink);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REQUIREMENT, vltrReq);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_TOTAL, recruitPeopleTotal);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_RECRUIT_PEOPLE_CURRENT, recruitPeopleCurrent);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_TIME, timeExpectTotal);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_ORIGANIZATIONID, origanizationId);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_CATEGORYID, categoryId);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_BTIMEID, bTimeId);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_REGIONID, regionId);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_SCHOOLID, schoolId);
                voluntaryValues.put(BongsaggunContracts.VoluntaryEntry.COLUMN_VOLUNTARY_UPDATEAT, updatedAt);

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
                schoolValues.put(BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_ID, id);
                schoolValues.put(BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_NAME, name);
                schoolValues.put(BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_CREATEAT, createdAt);
                schoolValues.put(BongsaggunContracts.SchoolEntry.COLUMN_SCHOOL_UPDATEAT, updatedAt);

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
                regionValues.put(BongsaggunContracts.RegionEntry.COLUMN_REGION_ID, id);
                regionValues.put(BongsaggunContracts.RegionEntry.COLUMN_REGION_NAME, name);
                regionValues.put(BongsaggunContracts.RegionEntry.COLUMN_REGION_CREATEAT, createdAt);
                regionValues.put(BongsaggunContracts.RegionEntry.COLUMN_REGION_UPDATEAT, updatedAt);

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
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_ID, id);
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_NAME, name);
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_MIN, min);
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_MAX, max);
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_CREATEAT, createdAt);
                timeValues.put(BongsaggunContracts.TimeEntry.COLUMN_TIME_UPDATEAT, updatedAt);

                cVVector.add(timeValues);
            }
            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<ContentValues> jsonCategoryListParser(String strJson) {

        try {
            JSONObject jsonObject = new JSONObject(strJson);
            Log.d(TAG, "jsonObject " + jsonObject);

            JSONArray jsonArray = jsonObject.getJSONArray("Category");

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

                ContentValues categoryValues = new ContentValues();
                categoryValues.put(BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_ID, id);
                categoryValues.put(BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_NAME, name);
                categoryValues.put(BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_CREATEAT, createdAt);
                categoryValues.put(BongsaggunContracts.CategoryEntry.COLUMN_CATEGORY_UPDATEAT, updatedAt);

                cVVector.add(categoryValues);
            }
            return cVVector;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
