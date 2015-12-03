package io.j2ffrey_2.bongsaggun;

import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Dong on 2015-11-27.
 */
//Todo: EndPoint, restAdapter, api Callback 구현
public class BackendHelper {

    private static final String endPoint = "https://dosomething-j2ffrey-2.c9.io";
    private static BackendHelper instance;
    private BackendService service;

    public static BackendHelper getInstance() {
        synchronized (BackendHelper.class) {
            if (instance == null) {
                instance = new BackendHelper();
            }
            return instance;
        }
    }

    private BackendHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BackendService.class);
    }

    //캘린더
    public Call<JsonObject> getCalendarList(int year, int month) {
        return service.getCalendarList(year, month);
    }

    //로그인
    public Call<JsonObject> doSignIn(String email, String passWord) {
        return service.doSignIn(email, passWord);
    }

    //상세페이지
    public Call<JsonObject> getInfoPage(int voluntaryId) {
        return service.getInfoPage(voluntaryId);
    }

    //찜하기
    public Call<JsonObject> addZzim(int userId, int voluntaryId) {
        return service.addZzim(userId, voluntaryId);
    }

    //찜리스트
    public Call<JsonObject> getZzimList(int userId) {
        return service.getZzimList(userId);
    }

    //홈리스트
    public Call<JsonObject> getHomeList(int voluntaryId, int limit) {
        return service.getHomeList(voluntaryId, limit);
    }

    //홈리스트
    public Call<JsonObject> getHomeList(int limit) {
        return service.getHomeList(limit);
    }
}
