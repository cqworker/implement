package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface InvitationApi {

    //POST tenant/invitation
    @POST("tenant/invitation")
    Call<ResponseBody> invitation(@Body RequestBody requestBody);


}
