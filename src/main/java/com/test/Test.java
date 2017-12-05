package com.test;

import com.google.gson.*;
import com.meta.entity.Schema;
import com.util.api.HttpImpl;
import com.util.api.MetaHttpApi;
import okhttp3.ResponseBody;
import retrofit2.Call;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by cq
 * date: 11/21 0021
 */
public class Test {
    public static void main(String[] args) {
        String token = "AQsCAH4ZylkAAEFRQUNkNVZWa2M3UkNBQUFQU0xlNHhRYzVCUWVDQUFBQVFBQ2Q1VlZrYzdSQ0FBQUFNWE80eFFjNUJRZENBQUHpdByJItptku7_xrJZvPRPvw8ETwX8c74DTTHaq5ClR2ouJbEKqLDInLz-P_KmENSsJMTtcrOe0pjlIlTItpid";
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl("10.100.250.133:7010", MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.getMeta("GuoXinLianCheng", "Contract");
        String result = "";
        String res = "[";
        Integer count = 1;//根据查询结果前台做分页
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //解析封装返回的json串
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        JsonObject obj = new JsonParser().parse(result).getAsJsonObject().get("body").getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entrySet = obj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            String v = entry.getValue().toString();
            //拼[{},{},{}]
            res += v + ",";
            count++;
        }
        //结尾空{}用来处理,
        Schema schema = new Schema();
        Gson gs = new Gson();
        System.out.println(gs.toJson(schema));
        res += "{}]";
        //根据code
        String json = "";
        if (code != 0) {
            String message = new JsonParser()
                    .parse(result)
                    .getAsJsonObject()
                    .get("body").getAsJsonObject()
                    .get("message").getAsString();
            json += "{\"code\":" + code + ",\"msg\": " + message + ",\"count\": " + count + ", \"data\":\"\"}";
            System.out.println(json);
        }
        json = "{\"code\": 0,\"msg\": \"\",\"count\": " + count + ", \"data\":" + res + "}";
        System.out.println(json);
    }



}
