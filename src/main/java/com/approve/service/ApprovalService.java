package com.approve.service;

import okhttp3.RequestBody;
import org.springframework.stereotype.Service;

/**
 * Created by cq
 * date: 12/4 0004
 */
public interface ApprovalService {
    /**
     * 获得对象审批模板
     * @param meta
     * @return
     */
    String  getApprovals(String tenement,String ip,String meta,String token);

    /**
     * 创建审批
     * @param requestBody
     * @param ip
     * @param token
     * @return
     */
    String addApproval(RequestBody requestBody,String tenement, String ip, String token);

    /**
     * 获得指定审批
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    String getApproval(String tenement,String template_id, String ip, String token);

    /**
     * 删除指定审批模板
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    String deleteApproval(String tenement,String template_id, String ip, String token);

    /**
     * 修改指定审批模板
     * @param requestBody
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    String editApproval(RequestBody requestBody, String tenement,String template_id, String ip, String token);

    /**
     * 开启和禁用模板
     * @param mark
     * @param template_id
     * @param ip
     * @param token
     * @return
     */
    String switchApproval(String tenement,Integer mark, String template_id, String ip, String token);
}
