package io.j2ffrey_2.bongsaggun;



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




}
