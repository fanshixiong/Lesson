package com.mapper.leave.leave;

import com.pojo.leave.Leave;
import com.pojo.reimbursement.ReimForm;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface LeaveMapper {
    @Select("select * from pd.leave where id = #{id}")
    Leave getFormByID(@Param("id") String id);

    @Select("select * from pd.leave where creator = #{staName}")
    List<Leave> getFormsByName(@Param("staName") String staName);

    @Insert("insert into pd.leave (id,createTime, creator, reason, modifyDate, state)" +
            "values(#{id}, #{createTime}, #{creator}, #{reason}, #{modifyDate}, #{state})")
    int addLeaveForm(Leave leave);

    @Update("update pd.leave set money = #{money} where id = #{id}")
    int updateLeaveForm(ReimForm reimForm);

    @Delete("delete from pd.leave where id = #{id}")
    int delLeaveForm(@Param("id") String id);

    @Select("select * from pd.leave where state = #{state}")
    List<Leave> getLeaveFormsByState(@Param("state")int state);

    @Select("select * from pd.leave")
    List<Leave> getAllLeave();

    @Update("update pd.leave set state = #{state}, modifyDate = #{date} where id = #{id}")
    int updateLeaveFormState(@Param("id")String id, @Param("state")Integer state, @Param("date") Date date);

}
