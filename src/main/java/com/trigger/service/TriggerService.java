package com.trigger.service;

import com.util.api.TriggerHttpApi;

import java.util.Map;

/**
 * Created by cq
 * date: 11/22 0022
 */

public interface TriggerService {
    /**
     *
     * @return
     */
    String getTrigger(String ip,String tenement,String meta,String token);

    /**
     * @param ip
     * @param tenement
     * @return
     */
    String addTrigger(String ip, String tenement,String meta,String token,Map map);

    /**
     * @param api
     */
    void init(TriggerHttpApi api);
}
