package com.mapper.leave;

import com.pojo.leave.Teastu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeastuMapper {
    @Select("select * from pd.teastu where id = #{id}")
    Teastu getteastuByID(@Param("id") String id);

    @Select("select * from pd.teastu where name = #{name}")
    Teastu getteastuByName(@Param("name") String name);

}
