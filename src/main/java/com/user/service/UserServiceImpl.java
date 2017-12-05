package com.user.service;

import com.user.dao.UserDao;
import com.user.entity.User;
import com.util.api.HttpImpl;
import com.util.api.UserApi;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import retrofit2.Call;

import java.util.List;

/**
 * Created by cq
 * date: 12/5 0005
 */
public class UserServiceImpl  implements UserService{

    @Autowired
    UserDao dao;
//    @Autowired
//    UserApi api;

    /**
     * 库中查询
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByUserName(String userName) {
        return dao.findByUserName(userName);
    }

    /**
     * 调用接口获得用户列表
     *
     * @return
     */
    @Override
    public List<User> getUsers() {
        UserApi api = (UserApi) HttpImpl.getHttpImpl("", UserApi.class,"");
        Call<ResponseBody> users = api.getUsers("");
        //
        return null;
    }
}
