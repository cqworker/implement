package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface TriggerHttpApi {
    //GET /api/v1.0/meiqia/car/meta/trigger
    @GET("api/v1.0/{tenement}/{meta}/meta/trigger")
    Call<ResponseBody> getTrigger(@Path("tenement") String tenement, @Path("meta") String meta);

    //POST /api/v1.0/meiqia/car/meta/trigger
    @POST("api/v1.0/{tenement}/{meta}/meta/trigger")
    Call<ResponseBody> addTrigger(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);


}
