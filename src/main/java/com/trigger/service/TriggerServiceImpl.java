package com.trigger.service;

import com.google.gson.Gson;
import com.util.GetJson;
import com.util.api.HttpImpl;
import com.util.api.TriggerHttpApi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;
import java.util.Map;

/**
 * Created by cq
 * date: 11/22 0022
 */
@Service
public class TriggerServiceImpl implements TriggerService {

    private TriggerHttpApi api;


    public void setApi(TriggerHttpApi api) {
        this.api = api;
    }


    Log log = LogFactory.getLog(TriggerServiceImpl.class);


    @Override
    public void init(TriggerHttpApi api) {
        setApi(api);
    }

    /**
     * 获得详情
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    @Override
    public String getTrigger(String ip, String tenement, String meta, String token) {
        TriggerHttpApi api = (TriggerHttpApi) HttpImpl.getHttpImpl(ip, TriggerHttpApi.class, token);
        Call<ResponseBody> trigger = api.getTrigger(tenement, meta);
        String result = "";
        try {
            result = trigger.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GetJson.getJsonBody(result);
    }

    /**
     * 添加trigger
     *
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @param map
     * @return
     */
    @Override
    public String addTrigger(String ip, String tenement,String meta,String token, Map map) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new Gson().toJson(map));
        TriggerHttpApi api = (TriggerHttpApi) HttpImpl.getHttpImpl(ip, TriggerHttpApi.class, token);
        Call<ResponseBody> trigger = api.addTrigger(requestBody, tenement, meta);
        String result = "";
        try {
            result = trigger.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return GetJson.getJson(result);
    }
}
