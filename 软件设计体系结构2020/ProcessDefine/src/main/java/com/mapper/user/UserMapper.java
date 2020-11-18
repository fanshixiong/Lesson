package com.mapper.user;

import com.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 根据 id 查询用户的信息
     * @param id 用户编号
     * @return 用户对象
     */
    @Select("select * from pd.user where id = #{id}")
    User getUserById(@Param("id") String id);

    @Select("select * from pd.user where userName = #{userName}")
    User getUserByUserName(@Param("userName") String userName);

    @Select("select * from pd.user")
    List<User> getAllUsers();

    /**
     *  新增 user
     * @param user 用户对象
     * @return 新增结果
     */
    @Insert("insert into pd.user (id, userName, userPassword, identity)" +
            "values(#{id}, #{userName}, #{userPassword}, #{identity})")
    int addUser(User user);

    /**
     *  根据 id 删除用户信息
     * @param id 用户编号
     * @return 删除结果
     */
    @Delete("delete from pd.user where id = #{id}")
    int delUser(@Param("id") String id);
}
