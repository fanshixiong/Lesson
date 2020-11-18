package com.mapper.leave.teacher;

import com.pojo.leave.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    /**
     * 根据 id 查询用户的信息
     * @param id 用户编号
     * @return 用户对象
     */
    @Select("select * from pd.teacher where id = #{id}")
    Teacher getTeacherByID(@Param("id") String id);

    @Select("select * from pd.teacher where teaName = #{teaName}")
    Teacher getTeacherByName(@Param("teaName") String teaName);

    /**
     *  新增 user
     * @param teacher 老师
     * @return 新增结果
     */
    @Insert("insert into pd.teacher (id, teaName, teaGender, teaAge, post)" +
            "values(#{id}, #{teaName}, #{teaGender}, #{teaAge}, #{post})")
    int addTeacher(Teacher teacher);

    /**
     *  根据 id 删除用户信息
     * @param id 用户编号
     * @return 删除结果
     */
    @Delete("delete from pd.teacher where id = #{id}")
    int delTeacher(@Param("id") int id);
}
