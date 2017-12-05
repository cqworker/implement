package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by cq
 * date: 12/4 0004
 */

@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 获得所有user
     *
     * @return
     */
    //https://crm.meiqia.com/dml/api/v1.0/meiqia/User/
    // query?order_by=updated_at&order_flag=DESC&limit=50&offset=0&curField=updated_at&curFlag=DESC
    //TODO
//        "dmlHost":"http://10.100.250.133:7010",
//        "ddlHost":"http://10.100.250.133:7020",
//        "aclHost":"http://10.100.250.6:7111",
//        "layoutHost":"http://10.100.1.139:8555",
//        "cdnHost":"https://crm.meiqia.com",
//        "loginHost":"http://10.100.250.164:7130",
//        "tenantHost":"http://10.100.250.218:7121",
//        "approvalHost":"http://10.100.250.133:7010",
//        "fileHost":"https://tri-file.meiqia.com",
//        "enterpriseInfoHost":"http://10.100.250.218:7121",
//        "imageHost":"https://eco-api-upload.meiqia.com",
//        "feedbackHost":"https://feedback.meiqia.com
    @RequestMapping("get/list")
    @ResponseBody
    public Object getUsers() {
        return null;
    }
}

