package com.trigger.service;

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
    Map<String,String> getTrigger(String ip,String tenement,String meta);

    /**
     * @param ip
     * @param tenement
     * @param meta
     * @return
     */
    Map<String,String> addTrigger(String ip, String tenement, String meta,Map map);
}
