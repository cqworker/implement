package com.layout.service;

import okhttp3.RequestBody;

/**
 * Created by cq
 * date: 12/4 0004
 */
public interface LayoutService {
    /**
     * 获得页面布局对象s
     * @param ip
     * @param id
     * @return
     */
    String getLayoutObjects(String ip, String id);

    /**
     * 获得指定对象的布局
     * @param ip
     * @param id
     * @param objName
     * @return
     */
    String getLayoutObject(String ip, String id, String objName);
}
