package com.mapper.leave.student;

import com.pojo.leave.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    /**
     * 根据 id 查询用户的信息
     * @param id 用户编号
     * @return 用户对象
     */
    @Select("select * from pd.student where id = #{id}")
    Student getStudentByID(@Param("id") String id);

    @Select("select * from pd.student where stuName = #{stuName}")
    Student getStudentByName(@Param("stuName") String stuName);

    /**
     *  新增 user
     * @param student 学生
     * @return 新增结果
     */
    @Insert("insert into pd.student (id, stuName, stuGender, stuAge)" +
            "values(#{id}, #{stuName}, #{stuGender}, #{stuAge})")
    int addStudent(Student student);

    /**
     *  根据 id 删除用户信息
     * @param id 用户编号
     * @return 删除结果
     */
    @Delete("delete from pd.student where id = #{id}")
    int delStudent(@Param("id") int id);
}
