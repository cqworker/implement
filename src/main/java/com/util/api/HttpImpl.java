package com.util.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import java.util.*;


/**
 * Created by cq
 * date: 11/16 0016 15:39
 */
@Service
public class HttpImpl {

    /**
     * get Retrofitimpl
     *
     * @param url
     * @param clzz
     * @return
     */
    public static Object getHttpImpl(String url, Class clzz,String token) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://" + url + "/")
                .client(RetrofitUtil.genericClient(token))
                .build();
        return retrofit.create(clzz);
    }

    /**
     * 填充dataMap
     *
     * @param result
     * @return
     */
    public static Map<String, Object> addDataMap(String result) {
        Map<String, Object> dataMap = new HashMap<>();
        List<Map<String,String>> metaList = new ArrayList<>();
        List<String>  tempList = new ArrayList<>();
        //判断code
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            dataMap.put("msg", msg);
            return dataMap;
        }
        //获得信息体
        JsonObject obj = new JsonParser().parse(result).getAsJsonObject().get("body").getAsJsonObject();


        Set<Map.Entry<String, JsonElement>> entrySet = obj.entrySet();
        //list[{k,v},{k,v},{k,v}]
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            String v  = entry.getValue().toString();
            String k = entry.getKey();
            tempList.add(k);
            Map<String,String> tempMap = new HashMap<>();
            tempMap.put(k,v);
            metaList.add(tempMap);
        }
        dataMap.put("metaList", metaList);
        dataMap.put("tempList",tempList);
        return dataMap;
    }
}
