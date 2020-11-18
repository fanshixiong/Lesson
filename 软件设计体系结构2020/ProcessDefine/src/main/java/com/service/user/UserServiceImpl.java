package com.service.user;

import com.mapper.user.UserMapper;
import com.mapper.user.UserMapperImpl;
import com.pojo.User;
import org.junit.Test;

import java.util.List;

public class UserServiceImpl implements UserService{

    private UserMapper userMapper;

    public UserServiceImpl() {
        this.userMapper = new UserMapperImpl();
    }

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User login(String userName, String userPassword) {
        User user = getUserByuserName(userName);
        if (user != null) {
            if (user.getUserPassword().equals(userPassword)) {
                return user;
            }
        }
        return null;
    }



    @Override
    public User getUserByuserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Test
    public void test(){
        // System.out.println(getUserByuserName("admin"));
        System.out.println(login("lys", "123456"));
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int delUser(String id) {
        return userMapper.delUser(id);
    }
}
