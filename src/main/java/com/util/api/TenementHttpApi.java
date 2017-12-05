package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface TenementHttpApi {

    @POST("api/v1.0/meiqia")
    Call<ResponseBody> addAccount(@Body RequestBody requestBody);



}
