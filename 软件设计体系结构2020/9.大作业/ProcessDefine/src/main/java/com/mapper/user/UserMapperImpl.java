package com.mapper.user;

import com.pojo.User;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperImpl implements UserMapper {

    @Override
    public User getUserById(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(id);
        sqlSession.commit();
        sqlSession.close();

        return user;
    }

    @Override
    public User getUserByUserName(String userName) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUserName(userName);
        sqlSession.commit();
        sqlSession.close();

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getAllUsers();
        sqlSession.commit();
        sqlSession.close();

        return users;
    }

    @Override
    public int addUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int addUser = mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();

        return addUser;
    }

    @Test
    public void test(){
        System.out.println(addUser(new User("1002", "frans", "123456", 1)));
    }

    @Override
    public int delUser(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int del = mapper.delUser(id);
        sqlSession.commit();
        sqlSession.close();

        return del;
    }
}
