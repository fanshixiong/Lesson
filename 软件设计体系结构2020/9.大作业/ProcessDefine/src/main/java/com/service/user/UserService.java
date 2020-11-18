package com.service.user;

import com.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);

    /** 验证登陆
     * @param userName 用户表
     * @return 验证登陆结果(i：用户编号，0：用户名密码不匹配，-1：用户名不存在)
     */
    User login(String userName, String userPassword);

    User getUserByuserName(String userName);

    List<User> getAllUsers();

    /**
     * 添加用户
     * @param user
     * @return 结果1：成功 0：失败
     */
    int addUser(User user);


    int delUser(String id);
}
