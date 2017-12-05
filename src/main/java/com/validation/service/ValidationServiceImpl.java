package com.validation.service;

import okhttp3.RequestBody;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cq
 * date: 11/21 0021
 */
@Service
public class ValidationServiceImpl implements ValidationService{
    /**
     * @param ip
     * @param tenement
     * @param meta
     * @return
     */

    @Override
    public List<String> getList(String ip, String tenement, String meta, String token) {
        return null;
    }

    @Override
    public Integer addValidation(RequestBody requestBody, String ip, String tenement, String meta) {
        return null;
    }

    @Override
    public String getValidation(String ip, String tenement, String meta, String validation_name, String token) {
        return null;
    }

    @Override
    public Integer deleteValidation(String ip, String tenement, String meta, String validation_name, String token) {
        return null;
    }

    @Override
    public Integer editValidation(RequestBody requestBody, String ip, String tenement, String meta, String validation_name, String token) {
        return null;
    }

    @Override
    public Integer openValidation(String ip, String tenement, String meta, String validation_name, String token) {
        return null;
    }

    @Override
    public Integer closeOneValidation(String ip, String tenement, String meta, String validation_name, String token) {
        return null;
    }
}
