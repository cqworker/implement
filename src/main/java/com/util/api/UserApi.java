package com.util.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cq
 * date: 12/5 0005
 */
public interface UserApi {

    @GET("")
    Call<ResponseBody> getUsers(@Path("tenement") String tenement);
}
