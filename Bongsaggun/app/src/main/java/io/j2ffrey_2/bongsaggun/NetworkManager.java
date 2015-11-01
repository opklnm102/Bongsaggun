package io.j2ffrey_2.bongsaggun;

import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONException;

import java.io.IOException;

import io.j2ffrey_2.bongsaggun.homelist.JsonParser;

/**
 * Created by dong on 2015-10-31.
 */
public class NetworkManager {

    public static final String TAG = NetworkManager.class.getSimpleName();

    private static NetworkManager instance;
    private OkHttpClient client;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * Restful api
     **/
    private String endPoint = "https://dosomething-j2ffrey-2.c9.io";
    private String format = "json";
    private String apiVoluntary = "filter";
    private String apiSchool = "school";
    private String apiRegion = "region";
    private String apiZzim = "my_bucket";
    private String apiLogin = "login";

    public static NetworkManager getInstance() {
        if (instance == null) {
            instance = new NetworkManager();
        }
        return instance;
    }

    private NetworkManager() {
        client = new OkHttpClient();
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

                    try {
                        JsonParser.jsonSchoolListParser(strJson);  //파싱한거 넘기기
                    } catch (JSONException e) {
                        e.printStackTrace();
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

                    try {
                        JsonParser.jsonRegionListParser(strJson);  //파싱한거 넘기기
                    } catch (JSONException e) {
                        e.printStackTrace();
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

                    try {
                        JsonParser.jsonVoluntaryListParser(strJson);  //파싱한거 넘기기
                    } catch (JSONException e) {
                        e.printStackTrace();
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

                    try {
                        JsonParser.jsonVoluntaryListParser(strJson);  //파싱한거 넘기기
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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
