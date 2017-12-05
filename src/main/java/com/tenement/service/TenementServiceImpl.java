package com.tenement.service;

import com.google.gson.JsonParser;
import com.util.api.HttpImpl;
import com.util.api.TenementHttpApi;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;

/**
 * Created by cq on 11/15 0015.
 */
@Service
public class TenementServiceImpl implements TenementService{

    /**
     * 创建租户
     * @param requestBody
     * @param ip
     * @param token
     * @return
     */
    @Override
    public Integer addAccount(RequestBody requestBody, String ip, String token) {
        TenementHttpApi api = (TenementHttpApi) HttpImpl.getHttpImpl(ip, TenementHttpApi.class,token);
        String result = "";
        try {
            Call<ResponseBody> body = api.addAccount(requestBody);
            result = body.execute().body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        if (code != 0) {
            return code;
        }
        return code;
    }

    /**
     * 获得租户详细信息
     * @param ip
     * @param id
     * @param token
     * @return
     */
    @Override
    public String getAccount(String ip, String id, String token) {
        return null;
    }
}
