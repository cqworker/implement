package com.tenement.service;

import okhttp3.RequestBody;

/**
 * Created by cq on 11/15 0015.
 */

public interface TenementService {

    /**
     * 创建租户
     * @param requestBody
     * @param ip
     * @param token
     * @return
     */
    Integer addAccount(RequestBody requestBody, String ip, String token);

    /**
     * 获取租户信息
     * @param ip
     * @param id
     * @param token
     * @return
     */
    String getAccount(String ip, String id, String token);
}
