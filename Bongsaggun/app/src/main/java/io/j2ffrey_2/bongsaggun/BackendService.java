package io.j2ffrey_2.bongsaggun;


import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Dong on 2015-11-26.
 */
//Todo: Restful api 정의
public interface BackendService {

    //캘린더
    @GET("/new_json/calendar")
    Call<JsonObject> getCalendarList(@Query("year") int year, @Query("month") int month);
    //http://dosomething-j2ffrey-2.c9.io/new_json/calendar?year=2015&month=11

    //로그인
    @GET("/new_json/signin")
    Call<JsonObject> doSignIn(@Query("email") String email, @Query("password") String passWord);
    //http://dosomething-j2ffrey-2.c9.io/new_json/signin?email=opklnm102@naver.com&password=1008

    //상세페이지
    @GET("/new_json/info")
    Call<JsonObject> getInfoPage(@Query("id") int voluntaryId);
    //http://dosomething-j2ffrey-2.c9.io/new_json/info?id=176

    //찜하기
    @GET("/new_json/bucket_save")
    Call<JsonObject> addZzim(@Query("u_id") int userId, @Query("b_id") int voluntaryId);
    //http://dosomething-j2ffrey-2.c9.io/new_json/bucket_save?u_id=52&b_id=176

    //찜리스트
    @GET("/new_json/bucket")
    Call<JsonObject> getZzimList(@Query("id") int userId);
    //http://dosomething-j2ffrey-2.c9.io/new_json/bucket?id=52

    //홈리스트
    @GET("/new_json/home")
    Call<JsonObject> getHomeList(@Query("id") int voluntaryId, @Query("limit") int limit);
    //http://dosomething-j2ffrey-2.c9.io/new_json/home?id=236&limit=5
    //현재 id 포함 5개 나온다.

    //홈리스트
    @GET("/new_json/home")
    Call<JsonObject> getHomeList(@Query("limit") int limit);
    //http://dosomething-j2ffrey-2.c9.io/new_json/home?limit=5

    //검색
    @GET("/new_json/filter")
    Call<JsonObject> getSearchList(@Query("s_word") String strSearch, @Query("category") int categoryId, @Query("region") int regionId, @Query("school") int schoolId, @Query("btime") int timeId);
    //http://dosomething-j2ffrey-2.c9.io/new_json/filter?s_word=%EB%B3%B4%EC%A1%B0&region=1&school=1&btime=1&category=1

    //검색
    @GET("/new_json/filter")
    Call<JsonObject> getSearchList(@Query("category") int categoryId, @Query("region") int regionId, @Query("school") int schoolId, @Query("btime") int timeId);
    //http://dosomething-j2ffrey-2.c9.io/new_json/filter?s_word=%EB%B3%B4%EC%A1%B0&region=1&school=1&btime=1&category=1


}
