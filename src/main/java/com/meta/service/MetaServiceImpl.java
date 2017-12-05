package com.meta.service;


import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.meta.entity.Schema;
import com.util.api.HttpImpl;
import com.util.api.MetaHttpApi;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.util.*;

/**
 * Created by cq
 * date: 11/16 0016 15:24
 */

@Service
public class MetaServiceImpl implements MetaService {

    /**
     * metaList
     *
     * @param ip
     * @param tenement
     * @param token
     * @return
     */
    @Override
    public String getAllMeta(String ip, String tenement, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.getAllMeta(tenement);
        String result = "";
        String res = "";
        Integer count = 1;
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
            String v = entry.getValue().getAsJsonObject().get("display_name").getAsString();
            String k = entry.getKey();
            //拼[{"name":"k","dis":"v"},{},{}]
            res += "{\"name\":\"" + k + "\",\"dis\":\"" + v + "\"},";
            count++;
        }
        //结尾空{}用来处理,
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
            return json;
        }
        json = "{\"code\": 0,\"msg\": \"\",\"count\": " + count + ", \"data\":[" + res + "}";
        System.out.println(json);
        return json;
    }

    /**
     * 删除单个meta
     *
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public Integer deleteMeta(String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.deleteMeta(tenement, meta);
        String result = "";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        return code;
    }

    /**
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public List getMeta(String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.getMetaSchema(tenement, meta);
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
        List resultList = new ArrayList<Schema>();
        for (Map.Entry<String, JsonElement> entry : entrySet) {
            Schema schema = new Schema();
            String v = entry.getValue().toString();
            if (new JsonParser().parse(v).getAsJsonObject().get("options") == null) {
                if (new JsonParser().parse(v).getAsJsonObject().get("default_value") == null) {
                    schema = new Gson().fromJson(v, new TypeToken<Schema>() {
                    }.getType());
                }
            } else {
                String str = new JsonParser().parse(v).getAsJsonObject()
                        .get("options").getAsJsonObject()
                        .get("list").getAsJsonObject()
                        .get("all").getAsJsonObject()
                        .get("options_value").getAsJsonArray().toString();
                List<String> option = new Gson().fromJson(str, new TypeToken<List<String>>() {
                }.getType());
                schema.setOptions(option);
                if (new JsonParser().parse(v).getAsJsonObject().get("default_value") != null) {
                    String default_value = new JsonParser().parse(v).getAsJsonObject()
                            .get("default_value").getAsJsonObject()
                            .get("value").getAsString();
                    schema.setDefault_value(default_value);
                }
            }
            resultList.add(schema);
        }
        return resultList;
    }

    /**
     * 新增meta
     *
     * @param requestBody
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public Integer addMeta(RequestBody requestBody, String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.addMeta(requestBody, tenement, meta);
        String result = "";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            //String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            //log记录
            return code;
        }
        return code;
    }

    @Override
    public Integer editMeta(RequestBody requestBody, String tenement, String meta, String token, Integer num) {
        return null;
    }

    /**
     * 创建meta字段
     *
     * @param requestBody
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public Integer addMetaSchema(RequestBody requestBody, String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.addField(requestBody, tenement, meta);
        String result = "";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            //String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            //log记录
            return code;
        }
        return code;
    }

    /**
     * 删除一列
     *
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public Integer deleteMetaSchema(RequestBody requestBody, String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.deleteMetaSchema(requestBody, tenement, meta);
        String result = "";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            //String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            //log记录
            return code;
        }


        return null;
    }

    @Override
    public Integer editMetaSchema(RequestBody requestBody, String ip, String tenement, String meta, String token) {
        MetaHttpApi api = (MetaHttpApi) HttpImpl.getHttpImpl(ip, MetaHttpApi.class, token);
        Call<ResponseBody> allMeta = api.editMetaSchema(requestBody, tenement, meta);
        String result = "";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            //String msg = new JsonParser().parse(result).getAsJsonObject().get("message").getAsString();
            //log记录
            return code;
        }
        return code;
    }
}
