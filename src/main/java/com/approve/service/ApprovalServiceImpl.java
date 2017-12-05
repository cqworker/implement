package com.approve.service;

import com.google.gson.*;
import com.util.api.ApprovalApi;
import com.util.api.HttpImpl;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用完成grpc接口调用
 * 使用Retrofit完成http接口调用
 * 使用Gson完成数据获取封装map返回给controller
 * Created by cq
 * date: 12/4 0004
 */
@Service
public class ApprovalServiceImpl implements  ApprovalService{
    /**
     * 获得对象的审批模板s
     * @param ip
     * @param meta
     * @param token
     * @return
     */
    @Override
    public String getApprovals(String tenement,String ip,String meta,String token) {
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        Call<ResponseBody> allMeta = api.getApprovals(tenement,meta);
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        Map dataMap = new HashMap<String,Object>();
        if(code!=0){
            dataMap.put("code",code);
            dataMap.put("body","error");
            return new Gson().toJson(dataMap);
        }else{
            //解析json
            JsonArray body = new JsonParser().parse(result).getAsJsonObject().get("body").getAsJsonArray();
            if(body!=null){
                Integer count = 0;
                for (JsonElement ja:body){
                    dataMap.put("code",code);
                    dataMap.put("CreateUid",ja.getAsJsonObject().get("CreateUid").getAsString());
                    dataMap.put("UpdateUid",ja.getAsJsonObject().get("UpdateUid").getAsString());
                    dataMap.put("Description", ja.getAsJsonObject().get("Description").getAsString());
                    dataMap.put("UseStatus",ja.getAsJsonObject().get("UseStatus").getAsString());
                    dataMap.put("Id",ja.getAsJsonObject().get("Id").getAsString());
                    dataMap.put("Script",ja.getAsJsonObject().get("Script").getAsString());
                    dataMap.put("StartScript",ja.getAsJsonObject().get("StartScript").getAsString());
                    count++;
                }
                dataMap.put("reBody",body.toString());
                dataMap.put("count",count);
            }
        }
        return new Gson().toJson(dataMap);
    }

    /**
     * 创建审批
     * @param requestBody
     * @param ip
     * @param token
     * @return
     */
    @Override
    public String addApproval(RequestBody requestBody, String tenement,String ip, String token) {
        Map dataMap = new HashMap<String ,Object>();
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        //
        Call<ResponseBody> allMeta = api.addApproval(requestBody,tenement);
        //
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        dataMap.put("code",code);
        //
        if(code!=0){
            String message = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            dataMap.put("message",message);
            return new Gson().toJson(dataMap);
        }else{
            JsonObject body = new JsonParser().parse(result).getAsJsonObject().get("body").getAsJsonObject();
            String id = body.get("body").getAsString();
            dataMap.put("id",id);
            return new Gson().toJson(dataMap);
        }
    }

    /**
     * 获得指定审批
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    @Override
    public String getApproval(String tenement,String template_id, String ip, String token) {
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        //
        Call<ResponseBody> allMeta = api.getApproval(tenement,template_id);
        //
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        //TODO 页面如何展示审批
        return null;
    }

    /**
     * 删除指定审批模板
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    @Override
    public String deleteApproval(String tenement,String template_id, String ip, String token) {
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        //
        Call<ResponseBody> allMeta = api.deleteApproval(tenement,template_id);
        //
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject resultObject = new JsonParser().parse(result).getAsJsonObject();
        Integer code = resultObject.get("code").getAsInt();
        //
        Map dataMap = new HashMap<String,Object>();
        dataMap.put("code",code);
        if(code!=0){
            String message = resultObject.get("message").getAsString();
            dataMap.put("message",message);
        }
            return new Gson().toJson(dataMap);

    }

    /**
     * 修改指定审批模板
     * @param requestBody
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    @Override
    public String editApproval(RequestBody requestBody,String tenement, String template_id, String ip, String token) {
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        //
        Call<ResponseBody> allMeta = api.editApproval(requestBody,tenement,template_id);
        //
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject resultObject = new JsonParser().parse(result).getAsJsonObject();
        Integer code = resultObject.get("code").getAsInt();
        //
        Map dataMap = new HashMap<String,Object>();
        dataMap.put("code",code);
        if(code!=0){
            String message = resultObject.get("message").getAsString();
            dataMap.put("message",message);
        }
        return new Gson().toJson(dataMap);

    }

    /**
     * 启用/禁用模板
     * @param mark
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    @Override
    public String switchApproval(String tenement,Integer mark, String template_id, String ip, String token) {
        ApprovalApi api = (ApprovalApi) HttpImpl.getHttpImpl(ip, ApprovalApi.class, token);
        Call<ResponseBody> allMeta = null;
        if(mark ==0){//启用
            allMeta = api.openApproval(tenement,template_id);
        }else {
            allMeta = api.closeApproval(tenement,template_id);
        }
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonObject resultObject = new JsonParser().parse(result).getAsJsonObject();
        Integer code = resultObject.get("code").getAsInt();
        //
        Map dataMap = new HashMap<String,Object>();
        dataMap.put("code",code);
        if(code!=0){
            String message = resultObject.get("message").getAsString();
            dataMap.put("message",message);
        }
        return new Gson().toJson(dataMap);

    }

}
