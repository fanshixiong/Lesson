package com.mapper.offdoc;

import com.pojo.leave.Leave;
import com.pojo.offdoc.offdocform;
import com.pojo.reimbursement.ReimForm;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface offdocMapper {
    @Select("select * from pd.offdocform where id = #{id}")
    offdocform getoffdocByID(@Param("id") String id);

    @Select("select * from pd.offdocform where creator = #{name}")
    List<offdocform> getoffdocByName(@Param("name") String name);

    @Insert("insert into pd.offdocform (id,createTime, creator, reason, modifyDate, Sstate, Astate, Bstate, Cstate)" +
            "values(#{id}, #{createTime}, #{creator}, #{reason}, #{modifyDate}, #{Sstate},#{Astate},#{Bstate},#{Cstate})")
    int addoffdoc(offdocform offdocform);

    @Update("update pd.offdocform set Sstate = 1 where id = #{id}")
    int updateoffdocAstate(offdocform offdocform);

    @Delete("delete from pd.offdocform where id = #{id}")
    int deloffdoc(@Param("id") String id);

    @Select("select * from pd.offdocform where Sstate = #{state}")
    List<offdocform> getoffdocBySstate(@Param("state") int state);

    @Select("select * from pd.offdocform")
    List<offdocform> getoffdoc();

    @Update("update pd.leaveform set Sstate = #{state}, modifyDate = #{date} where id = #{id}")
    int updateoffdocSstate(@Param("id") String id, @Param("state") Integer state, @Param("date") Date date);

}
