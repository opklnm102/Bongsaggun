package io.j2ffrey_2.bongsaggun;

import com.google.gson.JsonObject;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Dong on 2015-11-27.
 */
//Todo: EndPoint, restAdapter, api Callback 구현
public class BackendHelper {

    private static final String endPoint = "https://dosomething-j2ffrey-2.c9.io";
    private static BackendHelper instance;
    private BackendService service;

    public static BackendHelper getInstance(){
        if(instance == null){
            instance = new BackendHelper();
        }
        return instance;
    }

    private BackendHelper(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(BackendService.class);
    }

    //캘린더 리스트
    public Call<JsonObject> getCalendarList(int year, int month){
        return service.getCalendarList(year, month);
    }


}
