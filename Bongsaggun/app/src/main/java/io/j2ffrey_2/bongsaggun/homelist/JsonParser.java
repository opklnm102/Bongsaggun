package io.j2ffrey_2.bongsaggun.homelist;

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

public class JsonParser {

    static JSONObject object = null;
    static String json = "";
    static final String urlst = "https://dosomething-j2ffrey-2.c9.io/json/filter";

    public static  String id[];
    public static  String img_main="";
    public static final String img_poster="";

    public static final String name="";
    public static final String content="";
    public static final String is_edu="";

    public static final String status="";
    public static final String organization_id="";
    public static final String clerk_name="";
    public static final String clerk_call="";

    public static final String is_regular="";
    public static final String date_recruit_start="";
    public static final String date_recruit_end="";
    public static final String date_real_start="";
    public static final String date_real_end="";

    public static final String time_daily_start="";
    public static final String time_daily_end="";
    public static final String time_expect_total="";
    public static final String vltr_num="";
    public static final String vltr_age_id="";

    public static final String vltr_sex="";
    public static final String vltr_req="";
    public static final String region_id="";
    public static final String school_id="";
    public static final String btime_id="";


    public static final String category_id="";
    public static final String admin_add="";
    public static final String admin_mod="";
    public static final String act_time="";
    public static final String created_at="";
    public static final String updated_at="";



    public String[][] jsonParserList(String pRecvServerPage){
        String str="";


       // Log.i("서버에서 받은 전체 내용 :", con.getResult()+"la");
        try {

            JSONObject json = new JSONObject(pRecvServerPage);

            JSONArray jArr = json.getJSONArray("Bongsa"); // json object 넣는 배열

            // 받아온거 정리
            String[] jsonName = {"id", "img_name", "img_poster", "name", "content","is_edu","status", "organization_id","clerk_name", "clerk_call",
                                 "is_regular", "date_recruit_start", "date_recruit_end","date_real_start", "date_real_end", "time_daily_start","time_daily_end", "time_expect_total",
                                    "vltr_num", "vltr_age_id", "vltr_sex", "vltr_req", "region_id", "school_id", "btime_id", "category_id",
                                    "admin_add","admin_mod", "act_time","created_at", "updated_at"};

            String[][] parseredData = new String[jArr.length()][jsonName.length];

            for (int i = 0; i < jArr.length(); i++) {
                json = jArr.getJSONObject(i); //i =0 이면 첫번째 item

                for(int j = 0; j < jsonName.length; j++) {
                    parseredData[i][j] = json.getString(jsonName[j]);

                    //parseredData[0][0]  = 첫번째 아이템의 id

                    //아니면 배열로 받나?

                }
            }
            // 데이터 확인

            //Log.i("datacheck 1 : img_main", img_main);
            Log.i("언제 뜨나요 이거" , parseredData[1][2]);

            return parseredData;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }



}
