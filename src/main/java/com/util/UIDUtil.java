package com.util;

import java.util.UUID;

/**
 * Created by cq
 * date: 12/6 0006
 */
public class UIDUtil {
    public static String getUid(){
        return  UUID.randomUUID().toString().replaceAll("-", "");
    }



}
