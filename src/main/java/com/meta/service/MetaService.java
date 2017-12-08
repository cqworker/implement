package com.meta.service;


import com.meta.entity.Schema;
import okhttp3.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * Created by cq on 11/15 0015.
 */

public interface MetaService {
    /**
     * 获得所有meta
     * @param ip
     * @param tenement
     * @param token
     * @return
     */
    String getAllMeta(String ip, String tenement,String token);

    /**
     * 删除meta
     * @param ip
     * @param tenement
     * @return code
     */
    String deleteMeta(String ip, String tenement,String meta,String token);



    /**
     * 获得特定meta
     * @param ip
     * @param tenement
     * @param meta
     * @return meta 字段信息
     */
    List getMeta(String ip, String tenement, String meta, String token);

    /**
     * 添加meta
     * @param requestBody
     * @param tenement
     * @param meta
     * @return code
     */
    String addMeta(RequestBody requestBody, String ip,String tenement, String meta,String token);

    /**
     * 修改meta
     * @param requestBody
     * @param tenement
     * @param meta
     * @param num 1 2 3
     * @return
     */

    String editMeta(RequestBody requestBody, String tenement, String meta,String token,Integer num);

    /**
     * 为meta创建字段
     * @param requestBody
     * @param tenement
     * @param meta
     * @return
     */
    String addMetaSchema(RequestBody requestBody,String ip, String tenement, String meta,String token);



    /**
     * 删除meta字段
     * @param tenement
     * @param meta
     * @return
     */
    String deleteMetaSchema(RequestBody requestBody,String ip, String tenement, String meta,String token);

    /**
     * 修改meta字段
     * @param requestBody
     * @param tenement
     * @param meta
     * @return
     */
    String editMetaSchema(RequestBody requestBody, String ip,String tenement, String meta,String token);
}
