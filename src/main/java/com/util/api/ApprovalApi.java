package com.util.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by cq
 * date: 11/16 0016 15:34
 */
public interface ApprovalApi {

    /**
     * 获得对象的审批模板s
     * @param meta
     * @return
     */
    @GET("api/v1.0/{tenement}/service/approvals/template/object/{meta}")
    Call<ResponseBody> getApprovals(@Path("tenement") String tenement,@Path("meta") String meta);

    /**
     * 添加模板
     * @param requestBody
     * @return
     */
    //POST /api/:ver/:org-name/service/approvals/template
    @POST("api/v1.0/{tenement}/service/approvals/template")
    Call<ResponseBody> addApproval(@Body RequestBody requestBody,@Path("tenement") String tenement);

    /**
     * 获得指定模板
     * @param template_id
     * @return
     */
    //GET /api/:ver/:org-name/service/approvals/template/:template-id
    @GET("api/v1.0/{tenement}/service/approvals/template/{template_id}")
    Call<ResponseBody> getApproval(@Path("tenement") String tenement,@Path("template_id") String template_id);

    /**
     * 删除模板
     * @param template_id
     * @return
     */
    //DELETE /api/:ver/:org-name/service/approvals/template/:template-id
    @DELETE("api/v1.0/{tenement}/service/approvals/template/{template_id}")
    Call<ResponseBody> deleteApproval(@Path("tenement") String tenement,@Path("template_id") String template_id);

    /**
     * 编辑模板
     * @param requestBody
     * @param template_id
     * @return
     */
    //PUT /api/:ver/:org-name/service/approvals/template/:template-id
    @PUT("api/v1.0/{tenement}/service/approvals/template/{template_id}")
    Call<ResponseBody> editApproval(RequestBody requestBody,@Path("tenement") String tenement,@Path("template_id") String template_id);

    /**
     * 启用模板
     * @param template_id
     * @return
     */
    //PUT /api/:ver/:org-name/service/approvals/template/:template-id/active
    @PUT("api/v1.0/{tenement}/service/approvals/template/{template_id}/active")
    Call<ResponseBody> openApproval(@Path("tenement") String tenement,@Path("template_id") String template_id);

    /**
     * 禁用模板
     * @param template_id
     * @return
     */
    @PUT("api/v1.0/{tenement}/service/approvals/template/{template_id}/inactive")
    Call<ResponseBody> closeApproval(@Path("tenement") String tenement,@Path("template_id") String template_id);
}
