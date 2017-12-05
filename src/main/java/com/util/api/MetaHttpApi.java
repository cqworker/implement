package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface MetaHttpApi {
    //获得所有meta
    @GET("api/v1.0/{tenement}/all-metas?acl=true")
    Call<ResponseBody> getAllMeta(@Path("tenement") String tenement);

    //获得特定meta
    @GET("api/v1.0/{tenement}/{meta}/meta")
    Call<ResponseBody> getMeta(@Path("tenement") String tenement, @Path("meta") String meta);

    //删除特定meta
    @DELETE("api/v1.0/{tenement}/{meta}/meta")
    Call<ResponseBody> deleteMeta(@Path("tenement") String tenement, @Path("meta") String meta);

    //创建meta
    @POST("api/v1.0/{tenement}/{meta}/meta")
    Call<ResponseBody> addMeta(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);

    //创建字段
    @PUT("api/v1.0/{tenement}/{meta}/meta/add")
    Call<ResponseBody> addField(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);

    //删除字段
    @PUT("api/v1.0/{tenement}/{meta}/meta/drop")
    Call<ResponseBody> deleteMetaSchema(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);

    //添加territory_id字段
    @PUT("api/v1.0/{tenement}/{meta}/meta/add-territoryid")
    Call<ResponseBody> addTer(@Path("tenement") String tenement, @Path("meta") String meta);

    //修改字段属性
    @PUT("api/v1.0/{tenement}/{meta}/meta/schema")
    Call<ResponseBody> editMetaSchema(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);

    //获取meta所有列
    @GET("api/v1.0/{tenement}/{meta}/meta/schema")
    Call<ResponseBody> getMetaSchema(@Path("tenement") String tenement, @Path("meta") String meta);

    //修改meta display_name字段
    @PUT("api/v1.0/{tenement}/{meta}/meta/modify-displayName")
    Call<ResponseBody> putMetaDis(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);

    //修改meta description字段
    @PUT("api/v1.0/{tenement}/{meta}/meta/modify-description")
    Call<ResponseBody> putMetaDes(@Body RequestBody requestBody, @Path("tenement") String tenement, @Path("meta") String meta);
}
