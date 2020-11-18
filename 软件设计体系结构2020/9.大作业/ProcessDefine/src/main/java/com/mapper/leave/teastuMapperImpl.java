package com.mapper.leave;

import com.mapper.leave.student.StudentMapper;
import com.pojo.leave.Student;
import com.pojo.leave.teastu;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class teastuMapperImpl implements teastuMapper {


    @Override
    public teastu getteastuByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        teastuMapper mapper = sqlSession.getMapper(teastuMapper.class);
        teastu teastu = mapper.getteastuByID(id);
        sqlSession.commit();
        sqlSession.close();

        return teastu;
    }

    @Override
    public teastu getteastuByName(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        teastuMapper mapper = sqlSession.getMapper(teastuMapper.class);
        teastu teastu = mapper.getteastuByName(name);
        sqlSession.commit();
        sqlSession.close();

        return teastu;
    }
    @Test
    public void test(){
        System.out.println(getteastuByName("gch"));
    }
}
