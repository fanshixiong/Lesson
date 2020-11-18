package com.mapper.leave;

import com.pojo.leave.teastu;
import com.pojo.reimbursement.Staff;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface teastuMapper {
    @Select("select * from pd.teastu where id = #{id}")
    teastu getteastuByID(@Param("id") String id);

    @Select("select * from pd.teastu where name = #{name}")
    teastu getteastuByName(@Param("name") String name);

}
