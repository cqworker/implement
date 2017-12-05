package com.invitation.service;

import com.google.gson.JsonParser;
import com.util.api.HttpImpl;
import com.util.api.InvitationApi;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

/**
 * Created by cq
 * date: 11/26 0026
 */
@Service
public class InvitationServiceImpl implements InvitationService {
    @Override
    public Integer invitation(RequestBody requestBody, String ip, String token) {
        InvitationApi api = (InvitationApi) HttpImpl.getHttpImpl(ip, InvitationApi.class, token);
        Call<ResponseBody> allMeta = api.invitation(requestBody);
        String result ="";
        try {
            result = allMeta.execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer code = new JsonParser().parse(result).getAsJsonObject().get("code").getAsInt();
        return code;
    }
}
