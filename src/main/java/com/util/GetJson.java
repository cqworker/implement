package com.util;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cq
 * date: 12/7 0007
 */
public class GetJson {
    /**
     * 删除,添加判断是否成功
     * @param result
     * @return
     */
    public static  String getJson(String result){
        Map dataMap = new HashMap();
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            dataMap.put("success", false);
            dataMap.put("message", msg);
        } else {
            dataMap.put("success", true);
            dataMap.put("message", code);
        }
        return new Gson().toJson(dataMap);
    }

    /**
     * 获得详情
     * {success:true,body:}
     * {success:false,code:,message:}
     * @param result
     * @return
     */
    public static  String getJsonBody(String result){
        Map dataMap = new HashMap();
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            dataMap.put("success", false);
            dataMap.put("code",code);
            dataMap.put("message", msg);
        } else {
            String body = new JsonParser().parse(result).getAsJsonObject().get("body").getAsJsonObject().get("trigger").getAsString();
            dataMap.put("success", true);
            dataMap.put("body",body);
        }
        return new Gson().toJson(dataMap);
    }


}
