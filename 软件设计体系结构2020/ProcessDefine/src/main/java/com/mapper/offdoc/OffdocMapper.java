package com.mapper.offdoc;

import com.pojo.offdoc.Offdocform;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface OffdocMapper {
    @Select("select * from pd.offdocform where id = #{id}")
    Offdocform getoffdocByID(@Param("id") String id);

    @Select("select * from pd.offdocform where creator = #{name}")
    List<Offdocform> getoffdocByName(@Param("name") String name);

    @Insert("insert into pd.offdocform (id,createTime, creator, reason, modifyDate, sstate, Astate, Bstate, Cstate)" +
            "values(#{id}, #{createTime}, #{creator}, #{reason}, #{modifyDate}, #{sstate},#{Astate},#{Bstate},#{Cstate})")
    int addoffdoc(Offdocform offdocform);

    @Update("update pd.offdocform set Sstate = 1 where id = #{id}")
    int updateoffdocAstate(Offdocform offdocform);

    @Delete("delete from pd.offdocform where id = #{id}")
    int deloffdoc(@Param("id") String id);

    @Select("select * from pd.offdocform where sstate = #{state}")
    List<Offdocform> getoffdocBySstate(@Param("state") int state);

    @Select("select * from pd.offdocform")
    List<Offdocform> getoffdoc();

    @Update("update pd.leaveform set Sstate = #{state}, modifyDate = #{date} where id = #{id}")
    int updateoffdocSstate(@Param("id") String id, @Param("state") Integer state, @Param("date") Date date);

}
