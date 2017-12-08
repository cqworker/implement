package com.invitation.service;

import okhttp3.RequestBody;

/**
 * Created by cq
 * date: 11/26 0026
 */
public interface InvitationService {
    /**
     * 邀请用户
     * @param requestBody
     * @param ip
     * @param token
     * @return
     */
    String invitation(RequestBody requestBody, String ip, String token);
}
