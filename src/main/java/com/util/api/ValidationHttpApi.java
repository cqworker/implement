package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface ValidationHttpApi {
    @GET("api/v1.0/{tenement}/{meta}/meta/validations")
    Call<ResponseBody> getAllValidation(@PathVariable String tenement, @PathVariable String meta);

    @POST("api/v1.0/{tenement}/{meta}/meta/validations")
    Call<ResponseBody> addValidation(@Body RequestBody requestBody, @PathVariable String tenement, @PathVariable String meta);

    @GET("/api/v1.0/{tenement}/{meta}/meta/validations/{validation_name}")
    Call<ResponseBody> getOneValidation(@PathVariable String tenement, @PathVariable String meta, @PathVariable String validation_name);

    @DELETE("api/v1.0/{tenement}/{meta}/meta/validations/{validation_name}")
    Call<ResponseBody> deleteOneValidation(@PathVariable String tenement, @PathVariable String meta, @PathVariable String validation_name);

    @PUT("api/v1.0/{tenement}/{meta}/meta/validations/{validation_name}")
    Call<ResponseBody> putValidation(@Body RequestBody requestBody, @PathVariable String tenement,@PathVariable String meta);

    @PUT("api/v1.0/{tenement}/{meta}/meta/validations/{validation_name}/active")
    Call<ResponseBody> openOneValidation(@PathVariable String tenement,@PathVariable String meta,@PathVariable String validation_name);

    @PUT("api/v1.0/{tenement}/{meta}/meta/validations/{validation_name}/inactive")
    Call<ResponseBody> closeOneValidation(@PathVariable String tenement,@PathVariable String meta,@PathVariable String validation_name);

}
