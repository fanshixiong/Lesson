package com.mapper.reimbursement;

import com.pojo.reimbursement.ReimForm;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface ReimFormMapper {
    @Select("select * from pd.reimform where id = #{id}")
    ReimForm getFormByID(@Param("id") String id);

    @Select("select * from pd.reimform where creator = #{staName}")
    List<ReimForm> getReimFormsByName(@Param("staName") String staName);

    @Insert("insert into pd.reimform (id, money, createTime, creator, reason, modifyDate, state)" +
            "values(#{id}, #{money}, #{createTime}, #{creator}, #{reason}, #{modifyDate}, #{state})")
    int addReimForm(ReimForm reimForm);

    @Update("update pd.reimform set money = #{money} where id = #{id}")
    int updateReimForm(ReimForm reimForm);

    @Delete("delete from pd.reimform where id = #{id}")
    int delSReimForm(@Param("id") String id);

    @Select("select * from pd.reimform where state = #{state}")
    List<ReimForm> getReimFormsByState(@Param("state")int state);

    @Update("update pd.reimform set state = #{state}, modifyDate = #{date} where id = #{id}")
    int updateReimFormState(@Param("id")String id, @Param("state")Integer state, @Param("date")Date date);
}
