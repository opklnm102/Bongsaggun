package io.j2ffrey_2.bongsaggun;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Vector;

import io.j2ffrey_2.bongsaggun.homelist.JsonParser;

/**
 * Created by dong on 2015-10-31.
 */
public class NetworkManager {

    public static final String TAG = NetworkManager.class.getSimpleName();

    private static NetworkManager instance;
    private Context mContext;
    private OkHttpClient client;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * Restful api
     **/
    private String testEndPoint = "https://dosomething-j2ffrey-2.c9.io";  //c9 테스트 서버
    private String endPoint = "http://bongsaloadbalancer-882197660.ap-northeast-1.elb.amazonaws.com";
    private String format = "json";
    private String apiVoluntary = "filter";
    private String apiSchool = "school";
    private String apiRegion = "region";
    private String apiBtime = "btime";
    private String apiZzim = "my_bucket";
    private String apiLogin = "login";

    public static NetworkManager getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkManager(context);
        }
        return instance;
    }

    private NetworkManager(Context context) {
        client = new OkHttpClient();
        mContext = context;
    }

    //Todo: 회원가입
    //POST
    public void signin() {

    }

    //로그인
    //POST
    public void login(String email, String password) throws IOException {
        String url = endPoint + "/" + format + "/" + apiLogin;
        Log.d(TAG, " " + url);

        RequestBody formBody = new FormEncodingBuilder()
                .add("email", email)
                .add("password", password)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d(TAG, "login json " + response.body().string());
                }
            }
        });
    }

    //학교 리스트
    //GET
    public void getSchoolList() throws IOException {
        String url = endPoint + "/" + format + "/" + apiSchool;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String strJson = response.body().string();
                    Log.d(TAG, "school json " + strJson);

                    Vector<ContentValues> cVVector = JsonParser.jsonSchoolListParser(strJson);  //파싱한거 넘기기

                    //add to database
                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);

                        mContext.getContentResolver().bulkInsert(BongsaggunContract.SchoolEntry.CONTENT_URI, cvArray);

                        //updateAt보고 db갱신 할것
                    }
                }
            }
        });
    }

    //지역 리스트
    //GET
    public void getRegionList() throws IOException {
        String url = endPoint + "/" + format + "/" + apiRegion;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String strJson = response.body().string();
                    Log.d(TAG, "region json " + strJson);


                    Vector<ContentValues> cVVector = JsonParser.jsonRegionListParser(strJson);  //파싱한거 넘기기

                    //add to database
                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);

                        mContext.getContentResolver().bulkInsert(BongsaggunContract.RegionEntry.CONTENT_URI, cvArray);

                        //updateAt보고 db갱신 할것
                    }

                }
            }
        });
    }

    //봉사시간 분류 리스트
    public void getTimeList() throws IOException {
        String url = testEndPoint + "/" + format + "/" + apiBtime;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String strJson = response.body().string();
                    Log.d(TAG, "region json " + strJson);

                    Vector<ContentValues> cVVector = JsonParser.jsonTimeListParser(strJson);  //파싱한거 넘기기

                    //add to database
                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);

//                        mContext.getContentResolver().bulkInsert(BongsaggunContract.TimeEntry.CONTENT_URI, cvArray);

                        //updateAt보고 db갱신 할것
                    }

                }
            }
        });
    }


    //전체 봉사 리스트
    //GET
    public void getAllVoluntaryList() throws IOException {
        String url = endPoint + "/" + format + "/" + apiVoluntary;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String strJson = response.body().string();
                    Log.d(TAG, "allVoluntary json " + strJson);

                    Vector<ContentValues> cVVector = JsonParser.jsonVoluntaryListParser(strJson);  //파싱한거 넘기기

                    //add to database
                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);

                        mContext.getContentResolver().bulkInsert(BongsaggunContract.VoluntaryEntry.CONTENT_URI, cvArray);

                        //updateAt보고 db갱신 할것
                    }

                }
            }
        });
    }

    //봉사 리스트
    //GET
    //몇번 인덱스(offset)부터 몇개까지(limit)
    public void getVoluntaryList(int offset, int limit) throws IOException {
        String url = endPoint + "/" + format + "/" + apiVoluntary + "?offset=" + offset + "&limit=" + limit;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    String strJson = response.body().string();
                    Log.d(TAG, "voluntary json " + strJson);


                    JsonParser.jsonVoluntaryListParser(strJson);  //파싱한거 넘기기

                }
            }
        });
    }

    //찜 목록
    //GET
    public void getZzimList(int userId) {
        String url = endPoint + "/" + format + "/" + apiZzim + "?id=" + userId;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d(TAG, "ZzimList json " + response.body().string());
                }
            }
        });
    }

    //찜 추가
    //GET
    public void addZzim(int userId, int voluntaryId) {
        String url = endPoint + "/" + format + "/" + apiZzim + "_add?user_id=" + userId + "&id=" + voluntaryId;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d(TAG, "addZzim json " + response.body().string());
                }
            }
        });
    }

    //찜 취소
    //GET
    public void deleteZzim(int userId, int voluntaryId) {
        String url = endPoint + "/" + format + "/" + apiZzim + "_del?user_id=" + userId + "&id=" + voluntaryId;
        Log.d(TAG, " " + url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                } else {
                    Log.d(TAG, "addZzim json " + response.body().string());
                }
            }
        });
    }

    //Todo: 검색 api 구현
    public void search() {
//        HttpUrl url = new HttpUrl.Builder()
//            .scheme(protocol)
//            .host(endPoint)
//            .addPathSegment(api)
//            .addQueryParameter("q",)
    }

    //사용 example
//    try {
//        NetworkManager manager = NetworkManager.getInstance();
//
//        manager.getRegionList();
//        manager.getSchoolList();
//        manager.getAllVoluntaryList();
//        manager.getVoluntaryList(2, 4);
//        manager.getZzimList(1);
//        manager.addZzim(2, 5);
//        manager.login("spb828@naver.com", "4878");
//        manager.deleteZzim(2, 5);
//
//    } catch (IOException e) {
//        e.printStackTrace();
//    }


}
