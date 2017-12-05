package com.validation.service;

import okhttp3.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by cq on 11/15 0015.
 */

public interface ValidationService {

    /**
     * 获取validation列表
     * @param ip
     * @param tenement
     * @param meta
     * @param token
     * @return
     */
    List<String> getList(String ip, String tenement, String meta, String token);

    /**
     * 新建validation
     * @param requestBody
     * @param ip
     * @param tenement
     * @param meta
     * @return
     */
    Integer addValidation(RequestBody requestBody, String ip, String tenement, String meta);

    /**
     * 获得validation
     * @param ip
     * @param tenement
     * @param meta
     * @param validation_name
     * @return
     */
    String  getValidation(String ip, String tenement, String meta, String validation_name,String token);

    /**
     * 删除validation
     * @param ip
     * @param tenement
     * @param meta
     * @param validation_name
     * @param token
     * @return
     */
    Integer deleteValidation(String ip, String tenement, String meta, String validation_name, String token);

    /**
     * 修改validation
     * @param requestBody
     * @param ip
     * @param tenement
     * @param meta
     * @param validation_name
     * @param token
     * @return
     */
    Integer editValidation(RequestBody requestBody, String ip, String tenement, String meta, String validation_name, String token);

    /**
     * 启用validation
     * @param ip
     * @param tenement
     * @param meta
     * @param validation_name
     * @param token
     * @return
     */
    Integer openValidation(String ip, String tenement, String meta, String validation_name, String token);

    /**
     * 禁用validation
     * @param ip
     * @param tenement
     * @param meta
     * @param validation_name
     * @param token
     * @return
     */
    Integer closeOneValidation(String ip, String tenement, String meta, String validation_name, String token);
}
