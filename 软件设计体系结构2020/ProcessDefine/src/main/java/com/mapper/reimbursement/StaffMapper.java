package com.mapper.reimbursement;

import com.pojo.reimbursement.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StaffMapper {
    @Select("select * from pd.reimstaff where id = #{id}")
    Staff getStaffByID(@Param("id") String id);

    @Select("select * from pd.reimstaff where staName = #{staName}")
    Staff getStaffByName(@Param("staName") String staName);

    @Insert("insert into pd.reimstaff (id, staName, staGender, staAge, post)" +
            "values(#{id}, #{staName}, #{staGender}, #{staAge}, #{post})")
    int addStaff(Staff staff);

    @Delete("delete from pd.reimstaff where id = #{id}")
    int delStaff(@Param("id") int id);
}
