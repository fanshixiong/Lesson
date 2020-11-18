package com.mapper.leave;

import com.pojo.leave.Teastu;
import com.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeastuMapperImpl implements TeastuMapper {


    @Override
    public Teastu getteastuByID(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeastuMapper mapper = sqlSession.getMapper(TeastuMapper.class);
        Teastu teastu = mapper.getteastuByID(id);
        sqlSession.commit();
        sqlSession.close();

        return teastu;
    }

    @Override
    public Teastu getteastuByName(String name) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeastuMapper mapper = sqlSession.getMapper(TeastuMapper.class);
       Teastu teastu = mapper.getteastuByName(name);
        sqlSession.commit();
        sqlSession.close();

        return teastu;
    }
    @Test
    public void test(){
        System.out.println(getteastuByName("gch"));
    }
}
